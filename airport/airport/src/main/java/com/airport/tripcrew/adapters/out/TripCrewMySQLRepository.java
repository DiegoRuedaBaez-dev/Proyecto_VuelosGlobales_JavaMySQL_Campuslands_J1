package com.airport.tripcrew.adapters.out;

import com.airport.tripcrew.domain.models.TripCrew;
import com.airport.tripcrew.infrastructure.TripCrewRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TripCrewMySQLRepository implements TripCrewRepository {
    private final String url;
    private final String user;
    private final String password;

    public TripCrewMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(TripCrew tripCrew) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO trip_crews (id_employees, id_connection) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, tripCrew.getIdEmployees());
                statement.setInt(2, tripCrew.getIdConnection());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TripCrew tripCrew) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE trip_crews SET id_connection = ? WHERE id_employees = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripCrew.getIdConnection());
                statement.setString(2, tripCrew.getIdEmployees());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TripCrew> findById(String idEmployees, int idConnection) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM trip_crews WHERE id_employees = ? AND id_connection = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idEmployees);
                statement.setInt(2, idConnection);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        TripCrew tripCrew = new TripCrew(
                            resultSet.getString("id_employees"),
                            resultSet.getInt("id_connection")
                        );
                        return Optional.of(tripCrew);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String idEmployees, int idConnection) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM trip_crews WHERE id_employees = ? AND id_connection = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idEmployees);
                statement.setInt(2, idConnection);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TripCrew> findAll() {
        List<TripCrew> tripCrews = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM trip_crews";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TripCrew tripCrew = new TripCrew(
                        resultSet.getString("id_employees"),
                        resultSet.getInt("id_connection")
                    );
                    tripCrews.add(tripCrew);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripCrews;
    }
}
