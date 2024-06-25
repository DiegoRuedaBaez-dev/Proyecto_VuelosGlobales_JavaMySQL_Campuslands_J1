package com.airport.gate.application;

import com.airport.gate.domain.models.Gate;
import com.airport.gate.infrastructure.GateRepository;
import java.util.List;
import java.util.Optional;

public class GateService {
    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public void createGate(Gate gate) {
        gateRepository.save(gate);
    }

    public void updateGate(Gate gate) {
        gateRepository.update(gate);
    }

    public Optional<Gate> getGateById(int id) {
        return gateRepository.findById(id);
    }

    public void deleteGate(int id) {
        gateRepository.delete(id);
    }

    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }
}
