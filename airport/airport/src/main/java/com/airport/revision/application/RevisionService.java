package com.airport.revision.application;

import com.airport.revision.domain.models.Revision;
import com.airport.revision.infrastructure.RevisionRepository;
import java.util.List;
import java.util.Optional;

public class RevisionService {
    private final RevisionRepository revisionRepository;

    public RevisionService(RevisionRepository revisionRepository) {
        this.revisionRepository = revisionRepository;
    }

    public void createRevision(Revision revision) {
        revisionRepository.save(revision);
    }

    public void updateRevision(Revision revision) {
        revisionRepository.update(revision);
    }

    public Optional<Revision> getRevisionById(int id) {
        return revisionRepository.findById(id);
    }

    public void deleteRevision(int id) {
        revisionRepository.delete(id);
    }

    public List<Revision> getAllRevisions() {
        return revisionRepository.findAll();
    }
}
