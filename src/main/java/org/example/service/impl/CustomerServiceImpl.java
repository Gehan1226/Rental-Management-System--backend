package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(objectMapper.convertValue(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        Iterable<CustomerEntity> all = customerRepository.findAll();

        all.forEach(customerEntity -> customerList.add(objectMapper.convertValue(customerEntity, Customer.class)));
        return customerList;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return objectMapper.convertValue(customerRepository.findById(id), Customer.class);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Optional<CustomerEntity> byId = customerRepository.findById(customer.getId());

        if (byId.isPresent()){
            CustomerEntity existingEntity = byId.get();
            existingEntity.setName(customer.getName());
            existingEntity.setCity(customer.getCity());
            existingEntity.setContact(customer.getContact());
            customerRepository.save(existingEntity);
            return true;
        }
        return false;
    }
}
