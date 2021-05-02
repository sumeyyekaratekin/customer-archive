package com.sumeyye.customerArchive.service;
import com.sumeyye.customerArchive.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomer();
    void saveCustomer(Customer customer);
    Customer getCustomer(Integer id);
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer,Integer id);
}