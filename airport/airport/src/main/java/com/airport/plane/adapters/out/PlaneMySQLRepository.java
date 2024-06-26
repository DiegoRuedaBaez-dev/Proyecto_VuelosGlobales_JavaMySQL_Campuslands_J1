package com.airport.plane.adapters.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airport.plane.domain.models.Plane;
import com.airport.plane.infrastructure.PlaneRepository;

public class PlaneMySQLRepository implements PlaneRepository {
    private final String url;
    private final String user;
    private final String password;

    public PlaneMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

     public boolean checkPlane(Plane plane){
        //TODO: crear funcion para validar avion
        return true;
        
     }


    @Override
    public void save(Plane plane) {
    
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO planes (id, plates, capacity, fabrication_date, id_status, id_model) VALUES (?,?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, plane.getId());
                statement.setString(2, plane.getPlates());
                statement.setInt(3, plane.getCapacity());
                statement.setDate(4, Date.valueOf(plane.getFabricationDate()));
                statement.setInt(5, plane.getIdStatus());
                statement.setInt(6, plane.getIdModel());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void update(Plane plane) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE planes SET plates = ?, capacity = ?, fabrication_date = ?, id_status = ?, id_model = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, plane.getPlates());
                statement.setInt(2, plane.getCapacity());
                statement.setDate(3, Date.valueOf(plane.getFabricationDate()));
                statement.setInt(4, plane.getIdStatus());
                statement.setInt(5, plane.getIdModel());
                statement.setInt(6, plane.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Plane> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM planes WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Plane plane = new Plane(
                            resultSet.getInt("id"),
                            resultSet.getString("plates"),
                            resultSet.getInt("capacity"),
                            resultSet.getDate("fabrication_date").toLocalDate(),
                            resultSet.getInt("id_status"),
                            resultSet.getInt("id_model")
                        );
                        return Optional.of(plane);
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
            String query = "DELETE FROM planes WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plane> findAll() {
        List<Plane> planes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM planes";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Plane plane = new Plane(
                        resultSet.getInt("id"),
                        resultSet.getString("plates"),
                        resultSet.getInt("capacity"),
                        resultSet.getDate("fabrication_date").toLocalDate(),
                        resultSet.getInt("id_status"),
                        resultSet.getInt("id_model")
                    );
                    planes.add(plane);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }
}

