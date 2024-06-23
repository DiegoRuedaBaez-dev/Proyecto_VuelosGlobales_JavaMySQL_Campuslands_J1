package com.airport.status.infrastructure;

import com.airport.status.domain.models.Status;
import java.util.List;
import java.util.Optional;

public interface StatusRepository {
    void save(Status status);
    void update(Status status);
    Optional<Status> findById(int id);
    void delete(int id);
    List<Status> findAll();
}
