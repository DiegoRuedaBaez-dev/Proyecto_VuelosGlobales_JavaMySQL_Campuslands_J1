package com.airport.country.infrastructure;

import com.airport.country.domain.models.Country;
import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    void save(Country country);
    void update(Country country);
    Optional<Country> findById(String id);
    void delete(String id);
    List<Country> findAll();
}
