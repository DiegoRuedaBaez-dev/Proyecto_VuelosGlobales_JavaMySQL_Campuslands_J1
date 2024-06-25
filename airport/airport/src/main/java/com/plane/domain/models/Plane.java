package com.airport.plane.domain.models;

import java.time.LocalDate;

public class Plane {
    private int id;
    private String plates;
    private int capacity;
    private LocalDate fabricationDate;
    private int idStatus;
    private int idModel;

    // Constructor para crear un nuevo avión
    public Plane(String plates, int capacity, LocalDate fabricationDate, int idStatus, int idModel) {
        this.plates = plates;
        this.capacity = capacity;
        this.fabricationDate = fabricationDate;
        this.idStatus = idStatus;
        this.idModel = idModel;
    }

    // Constructor para actualizar un avión existente
    public Plane(int id, String plates, int capacity, LocalDate fabricationDate, int idStatus, int idModel) {
        this.id = id;
        this.plates = plates;
        this.capacity = capacity;
        this.fabricationDate = fabricationDate;
        this.idStatus = idStatus;
        this.idModel = idModel;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(LocalDate fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }
}
