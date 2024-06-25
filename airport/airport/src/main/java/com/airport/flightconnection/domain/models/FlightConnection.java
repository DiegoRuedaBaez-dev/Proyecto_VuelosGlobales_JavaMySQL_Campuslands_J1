package com.airport.flightconnection.domain.models;

public class FlightConnection {
    private int id;
    private String connectionNumber;
    private int idTrip;
    private int idPlane;
    private String idAirport;
    private int idTripStatus;

    // Constructor para crear una nueva conexión de vuelo
    public FlightConnection(String connectionNumber, int idTrip, int idPlane, String idAirport, int idTripStatus) {
        this.connectionNumber = connectionNumber;
        this.idTrip = idTrip;
        this.idPlane = idPlane;
        this.idAirport = idAirport;
        this.idTripStatus = idTripStatus;
    }

    // Constructor para actualizar una conexión de vuelo existente
    public FlightConnection(int id, String connectionNumber, int idTrip, int idPlane, String idAirport, int idTripStatus) {
        this.id = id;
        this.connectionNumber = connectionNumber;
        this.idTrip = idTrip;
        this.idPlane = idPlane;
        this.idAirport = idAirport;
        this.idTripStatus = idTripStatus;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(String connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public String getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }

    public int getIdTripStatus() {
        return idTripStatus;
    }

    public void setIdTripStatus(int idTripStatus) {
        this.idTripStatus = idTripStatus;
    }
}
