package com.airport.tripcrew.domain.models;

public class TripCrew {
    private String idEmployees;
    private int idConnection;

    // Constructor para actualizar un tripulación de viaje existente
    public TripCrew(String idEmployees, int idConnection) {
        this.idEmployees = idEmployees;
        this.idConnection = idConnection;
    }

    // Getters y Setters
    public String getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(String idEmployees) {
        this.idEmployees = idEmployees;
    }

    public int getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(int idConnection) {
        this.idConnection = idConnection;
    }
}
