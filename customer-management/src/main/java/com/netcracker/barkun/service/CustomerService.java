package com.netcracker.barkun.service;

import com.netcracker.barkun.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getById(Long id);

    Customer updateCustomer(Customer customer);

    void removeCustomer(Long id);
}
