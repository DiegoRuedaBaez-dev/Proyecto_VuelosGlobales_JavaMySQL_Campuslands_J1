package com.airport.trip.domain.models;

import java.time.LocalDate;

public class Trip {
    private int id;
    private LocalDate tripDate;
    private double priceTrip;

    // Constructor para crear un nuevo viaje
    public Trip(LocalDate tripDate, double priceTrip) {
        this.tripDate = tripDate;
        this.priceTrip = priceTrip;
    }

    // Constructor para actualizar un viaje existente
    public Trip(int id, LocalDate tripDate, double priceTrip) {
        this.id = id;
        this.tripDate = tripDate;
        this.priceTrip = priceTrip;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public double getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(double priceTrip) {
        this.priceTrip = priceTrip;
    }
}
