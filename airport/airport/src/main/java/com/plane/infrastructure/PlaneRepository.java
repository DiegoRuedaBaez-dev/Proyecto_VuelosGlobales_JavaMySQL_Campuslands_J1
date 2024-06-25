package com.airport.plane.infrastructure;

import com.airport.plane.domain.models.Plane;
import java.util.List;
import java.util.Optional;

public interface PlaneRepository {
    void save(Plane plane);
    void update(Plane plane);
    Optional<Plane> findById(int id);
    void delete(int id);
    List<Plane> findAll();
}
