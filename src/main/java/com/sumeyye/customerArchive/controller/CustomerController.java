package com.sumeyye.customerArchive.controller;

import com.sumeyye.customerArchive.service.CustomerServiceImpl;
import com.sumeyye.customerArchive.model.Customer;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;


    @GetMapping("/")
    public List<Customer> list() {
        String message = "";
        message = "Müşteriler Listelendi";
        return customerServiceImpl.listAllCustomer();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            Customer customer = customerServiceImpl.getCustomer(id);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Customer customer) {
        customerServiceImpl.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id) {
        try {
            customerServiceImpl.updateCustomer(customer, id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        customerServiceImpl.deleteCustomer(id);
    }
}
