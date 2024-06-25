package com.airport.plane.application;

import com.airport.plane.domain.models.Plane;
import com.airport.plane.infrastructure.PlaneRepository;
import java.util.List;
import java.util.Optional;

public class PlaneService {
    private final PlaneRepository planeRepository;

    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public void createPlane(Plane plane) {
        planeRepository.save(plane);
    }

    public void updatePlane(Plane plane) {
        planeRepository.update(plane);
    }

    public Optional<Plane> getPlaneById(int id) {
        return planeRepository.findById(id);
    }

    public void deletePlane(int id) {
        planeRepository.delete(id);
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }
}
