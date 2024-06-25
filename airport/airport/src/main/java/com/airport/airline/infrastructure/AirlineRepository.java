package com.airport.airline.infrastructure;

import com.airport.airline.domain.models.Airline;
import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    void save(Airline airline);
    void update(Airline airline);
    Optional<Airline> findById(int id);
    void delete(int id);
    List<Airline> findAll();
}
