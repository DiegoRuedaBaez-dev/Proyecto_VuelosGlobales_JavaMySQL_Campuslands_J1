package com.airport.revisionDetail.domain.models;

public class RevisionDetail {
    private String id;
    private String description;
    private String idEmployee;

    // Constructor para crear un nuevo detalle de revisión
    public RevisionDetail(String description, String idEmployee) {
        this.description = description;
        this.idEmployee = idEmployee;
    }

    // Constructor para actualizar un detalle de revisión existente
    public RevisionDetail(String id, String description, String idEmployee) {
        this.id = id;
        this.description = description;
        this.idEmployee = idEmployee;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }
}
