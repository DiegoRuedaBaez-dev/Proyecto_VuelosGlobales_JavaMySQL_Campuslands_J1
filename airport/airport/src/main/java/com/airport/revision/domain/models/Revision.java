package com.airport.revision.domain.models;

import java.time.LocalDate;

public class Revision {
    private int id;
    private LocalDate revisionDate;
    private int idPlane;

    // Constructor para crear una nueva revisión
    public Revision(LocalDate revisionDate, int idPlane) {
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
    }

    // Constructor para actualizar una revisión existente
    public Revision(int id, LocalDate revisionDate, int idPlane) {
        this.id = id;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDate revisionDate) {
        this.revisionDate = revisionDate;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public LocalDate getDate() {
        return revisionDate;
    }
}
