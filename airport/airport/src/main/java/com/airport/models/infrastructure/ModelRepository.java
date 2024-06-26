package com.airport.models.infrastructure;

import java.util.List;
import java.util.Optional;

import com.airport.models.domain.models.Model;

public interface ModelRepository {
    void save(Model model);
    void update(Model model);
    Optional<Model> findById(int id);
    void delete(int id);
    List<Model> findAll();
}