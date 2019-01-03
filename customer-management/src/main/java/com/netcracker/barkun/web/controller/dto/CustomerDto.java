package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CustomerDto extends BaseDto {

    private String name;

    private String email;

    private String phoneNumber;

    private RoleDto roleDto;

    private AddressDto addressDto;

    public CustomerDto() {
    }

    private CustomerDto(Customer customer){
        this.setId(customer.getId());
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.roleDto = RoleDto.convertFromRole(customer.getRole());
        this.addressDto = AddressDto.convertFromAddress(customer.getAddress());
    }

    public static CustomerDto convertFromCustomer(Customer customer){
        return new CustomerDto(customer);
    }

    public static List<CustomerDto> convertFromCustomer(List<Customer> customers){
        return customers.stream()
                .map(customer -> CustomerDto.convertFromCustomer(customer))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDto roleDto) {
        this.roleDto = roleDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(roleDto, that.roleDto) &&
                Objects.equals(addressDto, that.addressDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, phoneNumber, roleDto, addressDto);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("roleDto=" + roleDto)
                .add("addressDto=" + addressDto)
                .toString();
    }
}
