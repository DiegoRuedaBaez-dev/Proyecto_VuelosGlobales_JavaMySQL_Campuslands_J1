package com.airport.revEmployee.application;

import com.airport.revEmployee.domain.models.RevEmployee;
import com.airport.revEmployee.infrastructure.RevEmployeeRepository;
import java.util.List;
import java.util.Optional;

public class RevEmployeeService {
    private final RevEmployeeRepository revEmployeeRepository;

    public RevEmployeeService(RevEmployeeRepository revEmployeeRepository) {
        this.revEmployeeRepository = revEmployeeRepository;
    }

    public void createRevEmployee(RevEmployee revEmployee) {
        revEmployeeRepository.save(revEmployee);
    }

    public void updateRevEmployee(RevEmployee revEmployee) {
        revEmployeeRepository.update(revEmployee);
    }

    public Optional<RevEmployee> getRevEmployeeById(String idEmployee, int idRevision) {
        return revEmployeeRepository.findById(idEmployee, idRevision);
    }

    public void deleteRevEmployee(String idEmployee, int idRevision) {
        revEmployeeRepository.delete(idEmployee, idRevision);
    }

    public List<RevEmployee> getAllRevEmployees() {
        return revEmployeeRepository.findAll();
    }
}
