package com.airport.tripulationRole.application;

import java.util.List;
import java.util.Optional;

import com.airport.tripulationRole.domain.models.TripulationRole;
import com.airport.tripulationRole.infrastructure.TripulationRoleRepository;

public class TripulationRoleService {
    private final TripulationRoleRepository tripulationRoleRepository;

    public TripulationRoleService(TripulationRoleRepository tripulationRoleRepository) {
        this.tripulationRoleRepository = tripulationRoleRepository;
    }

    public void createTripulationRole(TripulationRole tripulationRole) {
        tripulationRoleRepository.save(tripulationRole);
    }

    public void updateTripulationRole(TripulationRole tripulationRole) {
        tripulationRoleRepository.update(tripulationRole);
    }

    public Optional<TripulationRole> getTripulationRoleById(int id) {
        return tripulationRoleRepository.findById(id);
    }

    public void deleteTripulationRole(int id) {
        tripulationRoleRepository.delete(id);
    }

    public List<TripulationRole> getAllTripulationRoles() {
        return tripulationRoleRepository.findAll();
    }
}
