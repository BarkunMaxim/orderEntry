package com.netcracker.barkun.entity;

import com.netcracker.barkun.web.controller.dto.CustomerDto;

import javax.persistence.*;

@Entity
public class Customer extends BaseEntity {

    private String name;

    private String email;

    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, Role role, Address address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
    }

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private Customer(CustomerDto customerDto){
        this.setId(customerDto.getId());
        this.name = customerDto.getName();
        this.email = customerDto.getEmail();
        this.phoneNumber = customerDto.getPhoneNumber();
        this.role = Role.convertFromRoleDto(customerDto.getRoleDto());
        this.address = Address.convertFromAddressDto(customerDto.getAddressDto());
    }

    public static Customer convertFromCustomerDto(CustomerDto customerDto){
        return new Customer(customerDto);
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", role=").append(role);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
