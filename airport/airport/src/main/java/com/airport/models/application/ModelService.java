package com.airport.models.application;

import com.airport.models.domain.models.Model;
import com.airport.models.infrastructure.ModelRepository;
import java.util.List;
import java.util.Optional;

public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public void createModel(Model model) {
        modelRepository.save(model);
    }

    public void updateModel(Model model) {
        modelRepository.update(model);
    }

    public Optional<Model> getModelById(int id) {
        return modelRepository.findById(id);
    }

    public void deleteModel(int id) {
        modelRepository.delete(id);
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }
}