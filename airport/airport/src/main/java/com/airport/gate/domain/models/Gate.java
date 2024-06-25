package com.airport.gate.domain.models;

public class Gate {
    private int id;
    private String gateNumber;
    private String idAirport;

    // Constructor para crear un nuevo gate
    public Gate(String gateNumber, String idAirport) {
        this.gateNumber = gateNumber;
        this.idAirport = idAirport;
    }

    // Constructor para actualizar un gate existente
    public Gate(int id, String gateNumber, String idAirport) {
        this.id = id;
        this.gateNumber = gateNumber;
        this.idAirport = idAirport;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }
}
