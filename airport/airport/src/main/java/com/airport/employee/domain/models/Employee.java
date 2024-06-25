package com.airport.employee.domain.models;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String name;
    private int idRol;
    private LocalDate ingressDate;
    private int idAirline;
    private String idAirport;

    // Constructor para crear un nuevo empleado
    public Employee(String id, String name, int idRol, LocalDate ingressDate, int idAirline, String idAirport) {
        this.id = id;
        this.name = name;
        this.idRol = idRol;
        this.ingressDate = ingressDate;
        this.idAirline = idAirline;
        this.idAirport = idAirport;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public LocalDate getIngressDate() {
        return ingressDate;
    }

    public void setIngressDate(LocalDate ingressDate) {
        this.ingressDate = ingressDate;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public String getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }
}
