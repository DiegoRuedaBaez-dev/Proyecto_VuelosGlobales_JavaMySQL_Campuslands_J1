package com.airport.status.application;

import com.airport.status.domain.models.Status;
import com.airport.status.infrastructure.StatusRepository;
import java.util.List;
import java.util.Optional;

public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void createStatus(Status status) {
        statusRepository.save(status);
    }

    public void updateStatus(Status status) {
        statusRepository.update(status);
    }

    public Optional<Status> getStatusById(int id) {
        return statusRepository.findById(id);
    }

    public void deleteStatus(int id) {
        statusRepository.delete(id);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
}
