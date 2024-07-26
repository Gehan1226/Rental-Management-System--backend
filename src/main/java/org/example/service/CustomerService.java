package org.example.service;

import org.example.dto.Customer;

import java.util.List;


public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomerById(Integer id);

    Integer getLastCustomerId();
}
