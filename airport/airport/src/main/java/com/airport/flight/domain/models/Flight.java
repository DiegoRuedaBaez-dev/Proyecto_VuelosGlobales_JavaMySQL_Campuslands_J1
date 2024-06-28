package com.airport.flight.domain.models;

public class Flight {
    private int id;
    private String connectionNumber;
    private int idTrip;
    private int idPlane;
    private String idAirport;
    private int idTripStatus;

    public Flight(int id, String connectionNumber, int idTrip, int idPlane, String idAirport, int idTripStatus) {
        this.id = id;
        this.connectionNumber = connectionNumber;
        this.idTrip = idTrip;
        this.idPlane = idPlane;
        this.idAirport = idAirport;
        this.idTripStatus = idTripStatus;
    }

    public int getId() { return id; }
    public String getConnectionNumber() { return connectionNumber; }
    public int getIdTrip() { return idTrip; }
    public int getIdPlane() { return idPlane; }
    public String getIdAirport() { return idAirport; }
    public int getIdTripStatus() { return idTripStatus; }
}
