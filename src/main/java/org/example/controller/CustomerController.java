package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.ok().body("Customer Saved!");
    }

    @GetMapping("/get-all")
    ResponseEntity<List<Customer>> getAllCustomers(){
        return  ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/get-by-id/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PutMapping("/update")
    ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        System.out.println(customer.getId());
        boolean result = customerService.updateCustomer(customer);
        if (result){
            return ResponseEntity.ok().body("Customer Update Successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found!");
    }

}
