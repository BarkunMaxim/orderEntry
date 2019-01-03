package com.netcracker.barkun.web.dto.customermanagement;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.Objects;
import java.util.StringJoiner;

public class AddressDto extends BaseDto {

    private String city;

    private String street;

    private int houseNumber;

    public AddressDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddressDto that = (AddressDto) o;
        return houseNumber == that.houseNumber &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, street, houseNumber);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressDto.class.getSimpleName() + "[", "]")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .add("houseNumber=" + houseNumber)
                .toString();
    }
}
