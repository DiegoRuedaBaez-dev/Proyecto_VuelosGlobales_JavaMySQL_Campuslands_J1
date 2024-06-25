package com.airport.country.domain.models;

public class Country {
    private String id;
    private String name;

    // Constructor para crear un nuevo país
    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
