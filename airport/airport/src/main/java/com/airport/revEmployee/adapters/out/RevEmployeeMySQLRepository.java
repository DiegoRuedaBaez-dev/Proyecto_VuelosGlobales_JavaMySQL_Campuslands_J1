package com.airport.revEmployee.adapters.out;

import com.airport.revEmployee.domain.models.RevEmployee;
import com.airport.revEmployee.infrastructure.RevEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RevEmployeeMySQLRepository implements RevEmployeeRepository {
    private final String url;
    private final String user;
    private final String password;

    public RevEmployeeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(RevEmployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO rev_employee (id_employee, id_revision) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, revEmployee.getIdEmployee());
                statement.setInt(2, revEmployee.getIdRevision());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(RevEmployee revEmployee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE rev_employee SET id_revision = ? WHERE id_employee = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, revEmployee.getIdRevision());
                statement.setString(2, revEmployee.getIdEmployee());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RevEmployee> findById(String idEmployee, int idRevision) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM rev_employee WHERE id_employee = ? AND id_revision = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idEmployee);
                statement.setInt(2, idRevision);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        RevEmployee revEmployee = new RevEmployee(
                            resultSet.getString("id_employee"),
                            resultSet.getInt("id_revision")
                        );
                        return Optional.of(revEmployee);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String idEmployee, int idRevision) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM rev_employee WHERE id_employee = ? AND id_revision = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, idEmployee);
                statement.setInt(2, idRevision);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RevEmployee> findAll() {
        List<RevEmployee> revEmployees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM rev_employee";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RevEmployee revEmployee = new RevEmployee(
                        resultSet.getString("id_employee"),
                        resultSet.getInt("id_revision")
                    );
                    revEmployees.add(revEmployee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revEmployees;
    }
}
