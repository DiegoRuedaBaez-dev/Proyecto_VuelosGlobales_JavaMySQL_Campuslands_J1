package com.airport.tripBooking.infrastructure;

import com.airport.tripBooking.domain.models.TripBooking;
import java.util.List;
import java.util.Optional;

public interface TripBookingRepository {
    void save(TripBooking tripBooking);
    void update(TripBooking tripBooking);
    Optional<TripBooking> findById(int id);
    void delete(int id);
    List<TripBooking> findAll();
}
