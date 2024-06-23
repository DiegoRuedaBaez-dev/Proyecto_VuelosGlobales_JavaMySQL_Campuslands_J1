package com.airport.revisionDetail.application;

import com.airport.revisionDetail.domain.models.RevisionDetail;
import com.airport.revisionDetail.infrastructure.RevisionDetailRepository;
import java.util.List;
import java.util.Optional;

public class RevisionDetailService {
    private final RevisionDetailRepository revisionDetailRepository;

    public RevisionDetailService(RevisionDetailRepository revisionDetailRepository) {
        this.revisionDetailRepository = revisionDetailRepository;
    }

    public void createRevisionDetail(RevisionDetail revisionDetail) {
        revisionDetailRepository.save(revisionDetail);
    }

    public void updateRevisionDetail(RevisionDetail revisionDetail) {
        revisionDetailRepository.update(revisionDetail);
    }

    public Optional<RevisionDetail> getRevisionDetailById(String id) {
        return revisionDetailRepository.findById(id);
    }

    public void deleteRevisionDetail(String id) {
        revisionDetailRepository.delete(id);
    }

    public List<RevisionDetail> getAllRevisionDetails() {
        return revisionDetailRepository.findAll();
    }
}
