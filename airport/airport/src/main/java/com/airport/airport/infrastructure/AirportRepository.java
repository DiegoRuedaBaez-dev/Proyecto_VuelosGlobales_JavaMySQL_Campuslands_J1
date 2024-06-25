package com.airport.airport.infrastructure;

import com.airport.airport.domain.models.Airport;
import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    void save(Airport airport);
    void update(Airport airport);
    Optional<Airport> findById(String id);
    void delete(String id);
    List<Airport> findAll();
}
