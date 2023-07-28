package com.company.customerdataservice.simplecrmapi.repository;

import com.company.customerdataservice.simplecrmapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface CustomerRepository extends JpaRepository<Customer, Integer> {

        List<Customer> findByState(String state);

        Customer findByFirstNameAndLastName(String firstName, String lastName);

        Customer findByCompanyAndState(String company, String state);
    }

