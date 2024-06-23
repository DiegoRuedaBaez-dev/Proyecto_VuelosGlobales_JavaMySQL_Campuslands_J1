package com.airport.revEmployee.infrastructure;

import com.airport.revEmployee.domain.models.RevEmployee;
import java.util.List;
import java.util.Optional;

public interface RevEmployeeRepository {
    void save(RevEmployee revEmployee);
    void update(RevEmployee revEmployee);
    Optional<RevEmployee> findById(String idEmployee, int idRevision);
    void delete(String idEmployee, int idRevision);
    List<RevEmployee> findAll();
}
