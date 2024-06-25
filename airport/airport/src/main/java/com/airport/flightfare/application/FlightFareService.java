package com.airport.flightfare.application;

import com.airport.flightfare.domain.models.FlightFare;
import com.airport.flightfare.infrastructure.FlightFareRepository;
import java.util.List;
import java.util.Optional;

public class FlightFareService {
    private final FlightFareRepository flightFareRepository;

    public FlightFareService(FlightFareRepository flightFareRepository) {
        this.flightFareRepository = flightFareRepository;
    }

    public void createFlightFare(FlightFare flightFare) {
        flightFareRepository.save(flightFare);
    }

    public void updateFlightFare(FlightFare flightFare) {
        flightFareRepository.update(flightFare);
    }

    public Optional<FlightFare> getFlightFareById(int id) {
        return flightFareRepository.findById(id);
    }

    public void deleteFlightFare(int id) {
        flightFareRepository.delete(id);
    }

    public List<FlightFare> getAllFlightFares() {
        return flightFareRepository.findAll();
    }
}
