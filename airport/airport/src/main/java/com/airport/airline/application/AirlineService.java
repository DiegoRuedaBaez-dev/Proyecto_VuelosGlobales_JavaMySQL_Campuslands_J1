package com.airport.airline.application;

import com.airport.airline.domain.models.Airline;
import com.airport.airline.infrastructure.AirlineRepository;
import java.util.List;
import java.util.Optional;

public class AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public void createAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    public void updateAirline(Airline airline) {
        airlineRepository.update(airline);
    }

    public Optional<Airline> getAirlineById(int id) {
        return airlineRepository.findById(id);
    }

    public void deleteAirline(int id) {
        airlineRepository.delete(id);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }
}
