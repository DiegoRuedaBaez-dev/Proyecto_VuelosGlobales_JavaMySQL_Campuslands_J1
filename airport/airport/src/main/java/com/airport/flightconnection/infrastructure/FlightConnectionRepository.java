package com.airport.flightconnection.infrastructure;

import com.airport.flightconnection.domain.models.FlightConnection;
import java.util.List;
import java.util.Optional;

public interface FlightConnectionRepository {
    void save(FlightConnection flightConnection);
    void update(FlightConnection flightConnection);
    Optional<FlightConnection> findById(int id);
    void delete(int id);
    List<FlightConnection> findAll();
}
