package com.airport.customer.infrastructure;

import com.airport.customer.domain.models.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    Optional<Customer> findById(String id);
    void delete(String id);
    List<Customer> findAll();
}
