package com.airport.city.application;

import com.airport.city.domain.models.City;
import com.airport.city.infrastructure.CityRepository;
import java.util.List;
import java.util.Optional;

public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void createCity(City city) {
        cityRepository.save(city);
    }

    public void updateCity(City city) {
        cityRepository.update(city);
    }

    public Optional<City> getCityById(String id) {
        return cityRepository.findById(id);
    }

    public void deleteCity(String id) {
        cityRepository.delete(id);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
