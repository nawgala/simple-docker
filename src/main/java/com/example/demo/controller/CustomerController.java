package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {
        logger.info("Request received to create customer [{}]", customer);
        final Customer saved;
        try {
            saved = customerRepository.save(customer);
            logger.info("Customer created successfully [{}]", saved);
            return saved;
        } catch (Exception e) {
            logger.error("Error while creating customer", e);
        }
        throw new RuntimeException("Error in customer creation flow");

    }
}
