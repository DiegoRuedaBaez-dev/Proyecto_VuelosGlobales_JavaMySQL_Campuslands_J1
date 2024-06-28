package com.airport.flight.adapters.out;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airport.flight.domain.models.Flight;
import com.airport.flight.infrastructure.FlightService;

public class FlightServiceImpl implements FlightService {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/airport";
    private final String jdbcUser = "root";
    private final String jdbcPassword = "password";

    @Override
    public List<Flight> searchFlights(String originCity, String destinationCity, LocalDate departureDate, LocalDate returnDate) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT c.id, c.connection_number, c.id_trip, c.id_plane, c.id_airport, c.id_trip_status " +
                       "FROM connections c " +
                       "JOIN trips t ON c.id_trip = t.id " +
                       "JOIN airports a1 ON a1.id = c.id_airport " +
                       "JOIN cities city1 ON a1.id_city = city1.id " +
                       "JOIN airports a2 ON c.id_airport = a2.id " +
                       "JOIN cities city2 ON a2.id_city = city2.id " +
                       "WHERE city1.name = ? AND city2.name = ? AND t.trip_date = ?";

        if (returnDate != null) {
            query += " AND c.id IN (SELECT c2.id FROM connections c2 JOIN trips t2 ON c2.id_trip = t2.id WHERE t2.trip_date = ?)";
        }

        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, originCity);
            stmt.setString(2, destinationCity);
            stmt.setDate(3, Date.valueOf(departureDate));
            if (returnDate != null) {
                stmt.setDate(4, Date.valueOf(returnDate));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Flight flight = new Flight(
                        rs.getInt("id"),
                        rs.getString("connection_number"),
                        rs.getInt("id_trip"),
                        rs.getInt("id_plane"),
                        rs.getString("id_airport"),
                        rs.getInt("id_trip_status")
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
