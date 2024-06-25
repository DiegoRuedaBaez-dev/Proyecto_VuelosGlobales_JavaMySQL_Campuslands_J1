package com.airport.customer.application;

import com.airport.customer.domain.models.Customer;
import com.airport.customer.infrastructure.CustomerRepository;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(String id) {
        customerRepository.delete(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
