package com.airport.status.domain.models;

public class Status {
    private int id;
    private String name;

    // Constructor para crear un nuevo estado
    public Status(String name) {
        this.name = name;
    }

    // Constructor para actualizar un estado existente
    public Status(int id, String name) {
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
