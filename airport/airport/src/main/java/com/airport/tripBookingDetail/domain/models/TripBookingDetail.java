package com.airport.tripBookingDetail.domain.models;

public class TripBookingDetail {
    private int id;
    private int idTripBooking;
    private String idCustomers;
    private int idFares;

    // Constructor para crear un nuevo detalle de reserva de viaje
    public TripBookingDetail(int idTripBooking, String idCustomers, int idFares) {
        this.idTripBooking = idTripBooking;
        this.idCustomers = idCustomers;
        this.idFares = idFares;
    }

    // Constructor para actualizar un detalle de reserva de viaje existente
    public TripBookingDetail(int id, int idTripBooking, String idCustomers, int idFares) {
        this.id = id;
        this.idTripBooking = idTripBooking;
        this.idCustomers = idCustomers;
        this.idFares = idFares;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTripBooking() {
        return idTripBooking;
    }

    public void setIdTripBooking(int idTripBooking) {
        this.idTripBooking = idTripBooking;
    }

    public String getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(String idCustomers) {
        this.idCustomers = idCustomers;
    }

    public int getIdFares() {
        return idFares;
    }

    public void setIdFares(int idFares) {
        this.idFares = idFares;
    }
}
