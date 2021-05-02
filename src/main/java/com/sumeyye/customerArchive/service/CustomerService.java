package com.sumeyye.customerArchive.service;

import com.sumeyye.customerArchive.model.Customer;
import com.sumeyye.customerArchive.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional

public class CustomerService implements CustomerServiceI{


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("%s idli kullanıcı bulunamadı", id)));
    }

    public void deleteCustomer(Integer id) {
        getCustomer(id); // check if customer not exist
        customerRepository.deleteById(id);

    }

    public void updateCustomer(Customer customer,Integer id) {
        getCustomer(id); // check if customer not exist
        customer.setId(id);
        saveCustomer(customer);

    }

}