package com.airport.employee.application;

import com.airport.employee.domain.models.Employee;
import com.airport.employee.infrastructure.EmployeeRepository;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(String id) {
        employeeRepository.delete(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
