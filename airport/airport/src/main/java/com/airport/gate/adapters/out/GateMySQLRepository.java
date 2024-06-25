package com.airport.gate.adapters.out;

import com.airport.gate.domain.models.Gate;
import com.airport.gate.infrastructure.GateRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GateMySQLRepository implements GateRepository {
    private final String url;
    private final String user;
    private final String password;

    public GateMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Gate gate) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO gates (gatenumber, id_airport) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, gate.getGateNumber());
                statement.setString(2, gate.getIdAirport());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Gate gate) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE gates SET gatenumber = ?, id_airport = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, gate.getGateNumber());
                statement.setString(2, gate.getIdAirport());
                statement.setInt(3, gate.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Gate> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM gates WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Gate gate = new Gate(
                            resultSet.getInt("id"),
                            resultSet.getString("gatenumber"),
                            resultSet.getString("id_airport")
                        );
                        return Optional.of(gate);
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
            String query = "DELETE FROM gates WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Gate> findAll() {
        List<Gate> gates = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM gates";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Gate gate = new Gate(
                        resultSet.getInt("id"),
                        resultSet.getString("gatenumber"),
                        resultSet.getString("id_airport")
                    );
                    gates.add(gate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gates;
    }
}
