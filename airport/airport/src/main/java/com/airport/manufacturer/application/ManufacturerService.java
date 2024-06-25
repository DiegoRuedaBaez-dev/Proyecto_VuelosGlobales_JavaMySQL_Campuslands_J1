package com.airport.manufacturer.application;

import com.airport.manufacturer.domain.models.Manufacturer;
import com.airport.manufacturer.infrastructure.ManufacturerRepository;
import java.util.List;
import java.util.Optional;

public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void createManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.update(manufacturer);
    }

    public Optional<Manufacturer> getManufacturerById(int id) {
        return manufacturerRepository.findById(id);
    }

    public void deleteManufacturer(int id) {
        manufacturerRepository.delete(id);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }
}
