package com.airport.tripulationRole.infrastructure;

import java.util.List;
import java.util.Optional;

import com.airport.tripulationRole.domain.models.TripulationRole;

public interface TripulationRoleRepository {
    void save(TripulationRole tripulationRole);
    void update(TripulationRole tripulationRole);
    Optional<TripulationRole> findById(int id);
    void delete(int id);
    List<TripulationRole> findAll();
}
