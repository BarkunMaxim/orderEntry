package com.netcracker.barkun.web.dto.customermanagement;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.Objects;
import java.util.StringJoiner;

public class RoleDto extends BaseDto {
    private String name;

    public RoleDto() {
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
