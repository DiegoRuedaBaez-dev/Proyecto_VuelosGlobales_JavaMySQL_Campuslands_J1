package com.airport.tripcrew.application;

import com.airport.tripcrew.domain.models.TripCrew;
import com.airport.tripcrew.infrastructure.TripCrewRepository;
import java.util.List;
import java.util.Optional;

public class TripCrewService {
    private final TripCrewRepository tripCrewRepository;

    public TripCrewService(TripCrewRepository tripCrewRepository) {
        this.tripCrewRepository = tripCrewRepository;
    }

    public void createTripCrew(TripCrew tripCrew) {
        tripCrewRepository.save(tripCrew);
    }

    public void updateTripCrew(TripCrew tripCrew) {
        tripCrewRepository.update(tripCrew);
    }

    public Optional<TripCrew> getTripCrewById(String idEmployees, int idConnection) {
        return tripCrewRepository.findById(idEmployees, idConnection);
    }

    public void deleteTripCrew(String idEmployees, int idConnection) {
        tripCrewRepository.delete(idEmployees, idConnection);
    }

    public List<TripCrew> getAllTripCrews() {
        return tripCrewRepository.findAll();
    }
}
