package com.airport.tripBooking.application;

import com.airport.tripBooking.domain.models.TripBooking;
import com.airport.tripBooking.infrastructure.TripBookingRepository;
import java.util.List;
import java.util.Optional;

public class TripBookingService {
    private final TripBookingRepository tripBookingRepository;

    public TripBookingService(TripBookingRepository tripBookingRepository) {
        this.tripBookingRepository = tripBookingRepository;
    }

    public void createTripBooking(TripBooking tripBooking) {
        tripBookingRepository.save(tripBooking);
    }

    public void updateTripBooking(TripBooking tripBooking) {
        tripBookingRepository.update(tripBooking);
    }

    public Optional<TripBooking> getTripBookingById(int id) {
        return tripBookingRepository.findById(id);
    }

    public void deleteTripBooking(int id) {
        tripBookingRepository.delete(id);
    }

    public List<TripBooking> getAllTripBookings() {
        return tripBookingRepository.findAll();
    }
}
