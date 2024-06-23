package com.airport.revisionDetail.infrastructure;

import com.airport.revisionDetail.domain.models.RevisionDetail;
import java.util.List;
import java.util.Optional;

public interface RevisionDetailRepository {
    void save(RevisionDetail revisionDetail);
    void update(RevisionDetail revisionDetail);
    Optional<RevisionDetail> findById(String id);
    void delete(String id);
    List<RevisionDetail> findAll();
}
