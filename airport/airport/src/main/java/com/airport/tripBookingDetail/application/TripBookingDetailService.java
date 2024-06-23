package com.airport.tripBookingDetail.application;

import java.util.List;
import java.util.Optional;

import com.airport.tripBookingDetail.domain.models.TripBookingDetail;
import com.airport.tripBookingDetail.infrastructure.TripBookingDetailRepository;

public class TripBookingDetailService {
    private final TripBookingDetailRepository tripBookingDetailRepository;

    public TripBookingDetailService(TripBookingDetailRepository tripBookingDetailRepository) {
        this.tripBookingDetailRepository = tripBookingDetailRepository;
    }

    public void createTripBookingDetail(TripBookingDetail tripBookingDetail) {
        tripBookingDetailRepository.save(tripBookingDetail);
    }

    public void updateTripBookingDetail(TripBookingDetail tripBookingDetail) {
        tripBookingDetailRepository.update(tripBookingDetail);
    }

    public Optional<TripBookingDetail> getTripBookingDetailById(int id) {
        return tripBookingDetailRepository.findById(id);
    }

    public void deleteTripBookingDetail(int id) {
        tripBookingDetailRepository.delete(id);
    }

    public List<TripBookingDetail> getAllTripBookingDetails() {
        return tripBookingDetailRepository.findAll();
    }
}
