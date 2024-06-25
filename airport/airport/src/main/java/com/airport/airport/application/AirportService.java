package com.airport.airport.application;

import com.airport.airport.domain.models.Airport;
import com.airport.airport.infrastructure.AirportRepository;
import java.util.List;
import java.util.Optional;

public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void updateAirport(Airport airport) {
        airportRepository.update(airport);
    }

    public Optional<Airport> getAirportById(String id) {
        return airportRepository.findById(id);
    }

    public void deleteAirport(String id) {
        airportRepository.delete(id);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
