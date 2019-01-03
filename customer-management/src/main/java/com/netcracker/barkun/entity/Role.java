package com.netcracker.barkun.entity;

import com.netcracker.barkun.web.controller.dto.RoleDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Role extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "role")
    private List<Customer> customers = new ArrayList<>();

    public Role() {
    }

    private Role(RoleDto roleDto){
        this.setId(roleDto.getId());
        this.name = roleDto.getName();
    }

    public static Role convertFromRoleDto(RoleDto roleDto){
        return new Role(roleDto);
    }
    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customerList) {
        this.customers = customerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name) &&
                Objects.equals(customers, role.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customers);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Role{");
        sb.append("name='").append(name).append('\'');
        sb.append(", customers=").append(customers);
        sb.append('}');
        return sb.toString();
    }
}
