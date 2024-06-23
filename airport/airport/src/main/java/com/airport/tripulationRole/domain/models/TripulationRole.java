package com.airport.tripulationRole.domain.models;

public class TripulationRole {
    private int id;
    private String name;

    // Constructor para crear un nuevo rol de tripulación
    public TripulationRole(String name) {
        this.name = name;
    }

    // Constructor para actualizar un rol de tripulación existente
    public TripulationRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
