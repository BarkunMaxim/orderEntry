package com.netcracker.barkun.entity;

import com.netcracker.barkun.web.controller.dto.AddressDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Address extends BaseEntity {

    private String city;

    private String street;

    private int houseNumber;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address() {
    }

    private Address(AddressDto addressDto){
        this.setId(addressDto.getId());
        this.city = addressDto.getCity();
        this.street = addressDto.getStreet();
        this.houseNumber = addressDto.getHouseNumber();
    }

    public static Address convertFromAddressDto(AddressDto addressDto){
        return new Address(addressDto);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(customer, address.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, houseNumber, customer);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", houseNumber=").append(houseNumber);
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }
}
