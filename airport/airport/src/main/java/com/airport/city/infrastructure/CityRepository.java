package com.airport.city.infrastructure;

import com.airport.city.domain.models.City;
import java.util.List;
import java.util.Optional;

public interface CityRepository {
    void save(City city);
    void update(City city);
    Optional<City> findById(String id);
    void delete(String id);
    List<City> findAll();
}
