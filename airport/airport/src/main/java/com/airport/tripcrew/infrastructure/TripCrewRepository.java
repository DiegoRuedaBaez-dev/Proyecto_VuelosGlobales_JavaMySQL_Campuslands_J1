package com.airport.tripcrew.infrastructure;

import com.airport.tripcrew.domain.models.TripCrew;
import java.util.List;
import java.util.Optional;

public interface TripCrewRepository {
    void save(TripCrew tripCrew);
    void update(TripCrew tripCrew);
    Optional<TripCrew> findById(String idEmployees, int idConnection);
    void delete(String idEmployees, int idConnection);
    List<TripCrew> findAll();
}
