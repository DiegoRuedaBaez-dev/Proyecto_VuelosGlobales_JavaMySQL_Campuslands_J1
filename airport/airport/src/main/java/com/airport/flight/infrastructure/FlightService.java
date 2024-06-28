package com.airport.flight.infrastructure;

import com.airport.flight.domain.models.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String originCity, String destinationCity, LocalDate departureDate, LocalDate returnDate);
}