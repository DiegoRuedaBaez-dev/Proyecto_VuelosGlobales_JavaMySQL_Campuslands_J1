package com.airport.flightconnection.adapters.out;

import com.airport.flightconnection.domain.models.FlightConnection;
import com.airport.flightconnection.infrastructure.FlightConnectionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightConnectionMySQLRepository implements FlightConnectionRepository {
    private final String url;
    private final String user;
    private final String password;

    public FlightConnectionMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(FlightConnection flightConnection) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO connections (connection_number, id_trip, id_plane, id_airport, id_trip_status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightConnection.getConnectionNumber());
                statement.setInt(2, flightConnection.getIdTrip());
                statement.setInt(3, flightConnection.getIdPlane());
                statement.setString(4, flightConnection.getIdAirport());
                statement.setInt(5, flightConnection.getIdTripStatus());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FlightConnection flightConnection) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE connections SET connection_number = ?, id_trip = ?, id_plane = ?, id_airport = ?, id_trip_status = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightConnection.getConnectionNumber());
                statement.setInt(2, flightConnection.getIdTrip());
                statement.setInt(3, flightConnection.getIdPlane());
                statement.setString(4, flightConnection.getIdAirport());
                statement.setInt(5, flightConnection.getIdTripStatus());
                statement.setInt(6, flightConnection.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FlightConnection> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM connections WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FlightConnection flightConnection = new FlightConnection(
                            resultSet.getInt("id"),
                            resultSet.getString("connection_number"),
                            resultSet.getInt("id_trip"),
                            resultSet.getInt("id_plane"),
                            resultSet.getString("id_airport"),
                            resultSet.getInt("id_trip_status")
                        );
                        return Optional.of(flightConnection);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM connections WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FlightConnection> findAll() {
        List<FlightConnection> flightConnections = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM connections";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    FlightConnection flightConnection = new FlightConnection(
                        resultSet.getInt("id"),
                        resultSet.getString("connection_number"),
                        resultSet.getInt("id_trip"),
                        resultSet.getInt("id_plane"),
                        resultSet.getString("id_airport"),
                        resultSet.getInt("id_trip_status")
                    );
                    flightConnections.add(flightConnection);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightConnections;
    }
}
