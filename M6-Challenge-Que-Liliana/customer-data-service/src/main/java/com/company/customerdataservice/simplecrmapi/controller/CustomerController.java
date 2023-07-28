package com.company.customerdataservice.simplecrmapi.controller;

import com.company.customerdataservice.simplecrmapi.model.Customer;
import com.company.customerdataservice.simplecrmapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    //This gets all customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    //This finds a customer by their id
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {

        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //This filters the customers by state
    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findByState(state);
    }

    //This creates a new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    //This updates an existing customer
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    //This deletes an existing customer
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }
}

