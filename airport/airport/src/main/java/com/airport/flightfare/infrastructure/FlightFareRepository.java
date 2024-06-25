package com.airport.flightfare.infrastructure;

import com.airport.flightfare.domain.models.FlightFare;
import java.util.List;
import java.util.Optional;

public interface FlightFareRepository {
    void save(FlightFare flightFare);
    void update(FlightFare flightFare);
    Optional<FlightFare> findById(int id);
    void delete(int id);
    List<FlightFare> findAll();
}
