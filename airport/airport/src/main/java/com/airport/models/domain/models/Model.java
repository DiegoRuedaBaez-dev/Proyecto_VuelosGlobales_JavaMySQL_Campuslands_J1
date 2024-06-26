package com.airport.models.domain.models;

public class Model {
    private int id;
    private String name;
    private int manufacturedId;

    // Constructor para crear un nuevo modelo
    public Model(String name, int manufacturedId) {
        this.name = name;
        this.manufacturedId = manufacturedId;
    }

    // Constructor para actualizar un modelo existente
    public Model(int id, String name, int manufacturedId) {
        this.id = id;
        this.name = name;
        this.manufacturedId = manufacturedId;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getManufacturedId() { return manufacturedId; }
    public void setManufacturedId(int manufacturedId) { this.manufacturedId = manufacturedId; }
}