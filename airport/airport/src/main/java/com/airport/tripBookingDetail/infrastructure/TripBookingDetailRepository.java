package com.airport.tripBookingDetail.infrastructure;

import java.util.List;
import java.util.Optional;

import com.airport.tripBookingDetail.domain.models.TripBookingDetail;

public interface TripBookingDetailRepository {
    void save(TripBookingDetail tripBookingDetail);
    void update(TripBookingDetail tripBookingDetail);
    Optional<TripBookingDetail> findById(int id);
    void delete(int id);
    List<TripBookingDetail> findAll();
}
