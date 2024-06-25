package com.airport.customer.domain.models;

public class Customer {
    private String id;
    private String name;
    private int age;
    private int idDocument;

    // Constructor para crear un nuevo cliente
    public Customer(String id, String name, int age, int idDocument) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idDocument = idDocument;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }
}

