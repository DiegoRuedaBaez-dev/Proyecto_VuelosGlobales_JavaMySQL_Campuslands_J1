package com.airport.manufacturer.infrastructure;

import com.airport.manufacturer.domain.models.Manufacturer;
import java.util.List;
import java.util.Optional;

public interface ManufacturerRepository {
    void save(Manufacturer manufacturer);
    void update(Manufacturer manufacturer);
    Optional<Manufacturer> findById(int id);
    void delete(int id);
    List<Manufacturer> findAll();
}
