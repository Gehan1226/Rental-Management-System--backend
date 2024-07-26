package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Customer;
import org.example.service.CustomerService;
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
        List<Customer> allCustomers = customerService.getAllCustomers();
        return  ResponseEntity.ok().body(allCustomers);
    }

}
