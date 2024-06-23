package com.airport.revEmployee.domain.models;

public class RevEmployee {
    private String idEmployee;
    private int idRevision;

    // Constructor para crear una nueva asignación de revisión
    public RevEmployee(String idEmployee, int idRevision) {
        this.idEmployee = idEmployee;
        this.idRevision = idRevision;
    }

    // Getters y Setters
    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }
}
