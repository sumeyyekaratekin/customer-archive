package com.sumeyye.customerArchive.repository;

import com.sumeyye.customerArchive.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer>{

}
