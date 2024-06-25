package com.airport.manufacturer.domain.models;

public class Manufacturer {
    private int id;
    private String name;

    // Constructor para crear un nuevo fabricante
    public Manufacturer(String name) {
        this.name = name;
    }

    // Constructor para actualizar un fabricante existente
    public Manufacturer(int id, String name) {
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
