package com.netcracker.barkun.dao;

import com.netcracker.barkun.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer createCustomer(Customer customer);

    List<Customer> findAllCustomer();

    Customer findById(Long id);

    Customer updateCustomer(Customer customer);

    void removeCustomer(Long id);

}
