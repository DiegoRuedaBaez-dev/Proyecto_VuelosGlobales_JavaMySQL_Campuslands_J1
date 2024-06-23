package com.airport.trip.application;

import com.airport.trip.domain.models.Trip;
import com.airport.trip.infrastructure.TripRepository;
import java.util.List;
import java.util.Optional;

public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void createTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void updateTrip(Trip trip) {
        tripRepository.update(trip);
    }

    public Optional<Trip> getTripById(int id) {
        return tripRepository.findById(id);
    }

    public void deleteTrip(int id) {
        tripRepository.delete(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
