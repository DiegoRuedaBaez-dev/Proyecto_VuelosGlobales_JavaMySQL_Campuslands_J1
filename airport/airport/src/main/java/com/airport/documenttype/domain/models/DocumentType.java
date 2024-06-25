package com.airport.documenttype.domain.models;

public class DocumentType {
    private int id;
    private String name;

    // Constructor para crear un nuevo tipo de documento
    public DocumentType(String name) {
        this.name = name;
    }

    // Constructor para actualizar un tipo de documento existente
    public DocumentType(int id, String name) {
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
