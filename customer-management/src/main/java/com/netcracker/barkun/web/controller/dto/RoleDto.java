package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Role;

import java.util.Objects;
import java.util.StringJoiner;

public class RoleDto extends BaseDto {

    private String name;

    public RoleDto() {
    }

    private RoleDto(Role role){
        this.setId(role.getId());
        this.name = role.getName();
    }

    public static RoleDto convertFromRole(Role role){
        return new RoleDto(role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(name, roleDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RoleDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
