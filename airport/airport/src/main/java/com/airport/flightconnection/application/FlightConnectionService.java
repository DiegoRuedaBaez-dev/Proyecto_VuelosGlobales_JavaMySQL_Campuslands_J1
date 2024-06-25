package com.airport.flightconnection.application;

import com.airport.flightconnection.domain.models.FlightConnection;
import com.airport.flightconnection.infrastructure.FlightConnectionRepository;
import java.util.List;
import java.util.Optional;

public class FlightConnectionService {
    private final FlightConnectionRepository flightConnectionRepository;

    public FlightConnectionService(FlightConnectionRepository flightConnectionRepository) {
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.save(flightConnection);
    }

    public void updateFlightConnection(FlightConnection flightConnection) {
        flightConnectionRepository.update(flightConnection);
    }

    public Optional<FlightConnection> getFlightConnectionById(int id) {
        return flightConnectionRepository.findById(id);
    }

    public void deleteFlightConnection(int id) {
        flightConnectionRepository.delete(id);
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionRepository.findAll();
    }
}
