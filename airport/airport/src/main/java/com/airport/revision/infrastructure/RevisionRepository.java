package com.airport.revision.infrastructure;

import com.airport.revision.domain.models.Revision;
import java.util.List;
import java.util.Optional;

public interface RevisionRepository {
    void save(Revision revision);
    void update(Revision revision);
    Optional<Revision> findById(int id);
    void delete(int id);
    List<Revision> findAll();
}
