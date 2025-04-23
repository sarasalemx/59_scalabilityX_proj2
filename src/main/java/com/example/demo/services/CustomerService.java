package com.example.demo.services;

import com.example.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repositories.CustomerRepository;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 8.2.2.1 Add Customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // 8.2.2.2 Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 8.2.2.3 Get Customer By ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null); // Or throw custom NotFoundException
    }

    // 8.2.2.4 Update Customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepository.save(customer);
        }).orElse(null); // Or throw custom NotFoundException
    }

    // 8.2.2.5 Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // 8.2.2.6 Find Customers By Email Domain
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailDomain(domain);
    }

    // 8.2.2.7 Find Customers By Phone Prefix
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}
