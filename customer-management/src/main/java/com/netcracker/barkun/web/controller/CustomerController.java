package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.entity.Customer;
import com.netcracker.barkun.service.CustomerService;
import com.netcracker.barkun.web.controller.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getAll() {
        return CustomerDto.convertFromCustomer(customerService.getAllCustomer());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping
    public CustomerDto get(@PathVariable("id") Long id) {
        return CustomerDto.convertFromCustomer(customerService.getById(id));
    }

    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.saveCustomer(Customer.convertFromCustomerDto(customerDto));
        return CustomerDto.convertFromCustomer(customer);
    }

    @PutMapping
    public CustomerDto update(@RequestBody CustomerDto newCustomer) {
        Customer customer = customerService.updateCustomer(Customer.convertFromCustomerDto(newCustomer));
        return CustomerDto.convertFromCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        customerService.removeCustomer(id);
    }
}
