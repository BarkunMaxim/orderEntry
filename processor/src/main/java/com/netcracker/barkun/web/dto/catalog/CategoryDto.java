package com.netcracker.barkun.web.dto.catalog;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.Objects;
import java.util.StringJoiner;

public class CategoryDto extends BaseDto {

    private String name;

    public CategoryDto() {
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
        CategoryDto that = (CategoryDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CategoryDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
