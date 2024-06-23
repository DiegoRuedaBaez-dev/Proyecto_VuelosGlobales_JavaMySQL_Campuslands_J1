package com.airport.tripBooking.domain.models;

import java.time.LocalDate;

public class TripBooking {
    private int id;
    private LocalDate date;
    private int idTrips;

    // Constructor para crear una nueva reserva de viaje
    public TripBooking(LocalDate date, int idTrips) {
        this.date = date;
        this.idTrips = idTrips;
    }

    // Constructor para actualizar una reserva de viaje existente
    public TripBooking(int id, LocalDate date, int idTrips) {
        this.id = id;
        this.date = date;
        this.idTrips = idTrips;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getIdTrips() {
        return idTrips;
    }

    public void setIdTrips(int idTrips) {
        this.idTrips = idTrips;
    }
}
