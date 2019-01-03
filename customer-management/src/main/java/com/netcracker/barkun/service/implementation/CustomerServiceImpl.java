package com.netcracker.barkun.service.implementation;

import com.netcracker.barkun.dao.CustomerDao;
import com.netcracker.barkun.entity.Customer;
import com.netcracker.barkun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.findAllCustomer();
    }

    @Override
    public Customer getById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(Long id) {
        customerDao.removeCustomer(id);
    }
}
