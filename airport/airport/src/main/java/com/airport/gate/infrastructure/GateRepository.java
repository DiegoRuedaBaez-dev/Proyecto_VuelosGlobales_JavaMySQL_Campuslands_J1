package com.airport.gate.infrastructure;

import com.airport.gate.domain.models.Gate;
import java.util.List;
import java.util.Optional;

public interface GateRepository {
    void save(Gate gate);
    void update(Gate gate);
    Optional<Gate> findById(int id);
    void delete(int id);
    List<Gate> findAll();
}
