package com.airport.tripBookingDetail.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.airport.tripBookingDetail.domain.models.TripBookingDetail;
import com.airport.tripBookingDetail.infrastructure.TripBookingDetailRepository;

public class TripBookingDetailMySQLRepository implements TripBookingDetailRepository {
    private final String url;
    private final String user;
    private final String password;

    public TripBookingDetailMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(TripBookingDetail tripBookingDetail) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO trip_booking_details (id_trip_booking, id_customers, id_fares) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripBookingDetail.getIdTripBooking());
                statement.setString(2, tripBookingDetail.getIdCustomers());
                statement.setInt(3, tripBookingDetail.getIdFares());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TripBookingDetail tripBookingDetail) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE trip_booking_details SET id_trip_booking = ?, id_customers = ?, id_fares = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripBookingDetail.getIdTripBooking());
                statement.setString(2, tripBookingDetail.getIdCustomers());
                statement.setInt(3, tripBookingDetail.getIdFares());
                statement.setInt(4, tripBookingDetail.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TripBookingDetail> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM trip_booking_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        TripBookingDetail tripBookingDetail = new TripBookingDetail(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_trip_booking"),
                            resultSet.getString("id_customers"),
                            resultSet.getInt("id_fares")
                        );
                        return Optional.of(tripBookingDetail);
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
            String query = "DELETE FROM trip_booking_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TripBookingDetail> findAll() {
        List<TripBookingDetail> tripBookingDetails = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM trip_booking_details";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TripBookingDetail tripBookingDetail = new TripBookingDetail(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_trip_booking"),
                        resultSet.getString("id_customers"),
                        resultSet.getInt("id_fares")
                    );
                    tripBookingDetails.add(tripBookingDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripBookingDetails;
    }
}
