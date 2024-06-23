package com.airport.revisionDetail.adapters.out;

import com.airport.revisionDetail.domain.models.RevisionDetail;
import com.airport.revisionDetail.infrastructure.RevisionDetailRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RevisionDetailMySQLRepository implements RevisionDetailRepository {
    private final String url;
    private final String user;
    private final String password;

    public RevisionDetailMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(RevisionDetail revisionDetail) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revisions_details (id, descriptions, id_employee) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, revisionDetail.getId());
                statement.setString(2, revisionDetail.getDescription());
                statement.setString(3, revisionDetail.getIdEmployee());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(RevisionDetail revisionDetail) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE revisions_details SET descriptions = ?, id_employee = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, revisionDetail.getDescription());
                statement.setString(2, revisionDetail.getIdEmployee());
                statement.setString(3, revisionDetail.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RevisionDetail> findById(String id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM revisions_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        RevisionDetail revisionDetail = new RevisionDetail(
                            resultSet.getString("id"),
                            resultSet.getString("descriptions"),
                            resultSet.getString("id_employee")
                        );
                        return Optional.of(revisionDetail);
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
            String query = "DELETE FROM revisions_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RevisionDetail> findAll() {
        List<RevisionDetail> revisionDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM revisions_details";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RevisionDetail revisionDetail = new RevisionDetail(
                        resultSet.getString("id"),
                        resultSet.getString("descriptions"),
                        resultSet.getString("id_employee")
                    );
                    revisionDetails.add(revisionDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revisionDetails;
    }
}
