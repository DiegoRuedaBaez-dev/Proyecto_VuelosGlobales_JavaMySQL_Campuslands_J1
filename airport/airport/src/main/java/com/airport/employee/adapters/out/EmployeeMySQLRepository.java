package com.airport.employee.adapters.out;

import com.airport.employee.domain.models.Employee;
import com.airport.employee.infrastructure.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeMySQLRepository implements EmployeeRepository {
    private final String url;
    private final String user;
    private final String password;

    public EmployeeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO employees (id, name, id_rol, ingress_date, id_airline, id_airport) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, employee.getId());
                statement.setString(2, employee.getName());
                statement.setInt(3, employee.getIdRol());
                statement.setDate(4, Date.valueOf(employee.getIngressDate()));
                statement.setInt(5, employee.getIdAirline());
                statement.setString(6, employee.getIdAirport());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employees SET name = ?, id_rol = ?, ingress_date = ?, id_airline = ?, id_airport = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, employee.getName());
                statement.setInt(2, employee.getIdRol());
                statement.setDate(3, Date.valueOf(employee.getIngressDate()));
                statement.setInt(4, employee.getIdAirline());
                statement.setString(5, employee.getIdAirport());
                statement.setString(6, employee.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> findById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM employees WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Employee employee = new Employee(
                            resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("id_rol"),
                            resultSet.getDate("ingress_date").toLocalDate(),
                            resultSet.getInt("id_airline"),
                            resultSet.getString("id_airport")
                        );
                        return Optional.of(employee);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM employees WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM employees";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("id_rol"),
                        resultSet.getDate("ingress_date").toLocalDate(),
                        resultSet.getInt("id_airline"),
                        resultSet.getString("id_airport")
                    );
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
