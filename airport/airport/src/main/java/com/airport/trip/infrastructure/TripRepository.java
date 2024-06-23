package com.airport.trip.infrastructure;

import com.airport.trip.domain.models.Trip;
import java.util.List;
import java.util.Optional;

public interface TripRepository {
    void save(Trip trip);
    void update(Trip trip);
    Optional<Trip> findById(int id);
    void delete(int id);
    List<Trip> findAll();
}
