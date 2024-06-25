package com.airport.employee.infrastructure;

import com.airport.employee.domain.models.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    Optional<Employee> findById(String id);
    void delete(String id);
    List<Employee> findAll();
}
