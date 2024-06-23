package com.airport.revision.adapters.out;

import com.airport.revision.domain.models.Revision;
import com.airport.revision.infrastructure.RevisionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RevisionMySQLRepository implements RevisionRepository {
    private final String url;
    private final String user;
    private final String password;

    public RevisionMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Revision revision) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revisions (revisions_date, id_plane) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, Date.valueOf(revision.getRevisionDate()));
                statement.setInt(2, revision.getIdPlane());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Revision revision) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE revisions SET revisions_date = ?, id_plane = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, Date.valueOf(revision.getRevisionDate()));
                statement.setInt(2, revision.getIdPlane());
                statement.setInt(3, revision.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Revision> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM revisions WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Revision revision = new Revision(
                            resultSet.getInt("id"),
                            resultSet.getDate("revisions_date").toLocalDate(),
                            resultSet.getInt("id_plane")
                        );
                        return Optional.of(revision);
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
            String query = "DELETE FROM revisions WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Revision> findAll() {
        List<Revision> revisions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM revisions";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Revision revision = new Revision(
                        resultSet.getInt("id"),
                        resultSet.getDate("revisions_date").toLocalDate(),
                        resultSet.getInt("id_plane")
                    );
                    revisions.add(revision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revisions;
    }
}

