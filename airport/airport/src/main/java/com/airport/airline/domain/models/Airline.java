package com.airport.airline.domain.models;

public class Airline {
    private int id;
    private String name;

    // Constructor para crear una nueva aerolínea
    public Airline(String name) {
        this.name = name;
    }

    // Constructor para actualizar una aerolínea existente
    public Airline(int id, String name) {
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
