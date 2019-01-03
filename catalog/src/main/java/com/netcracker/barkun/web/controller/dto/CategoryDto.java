package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.entity.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CategoryDto extends BaseDto {

    private String name;

    public CategoryDto() {
    }

    private CategoryDto(Category category){
        this.setId(category.getId());
        this.name = category.getName();
    }

    public static CategoryDto convertFromCategory(Category category){
        return new CategoryDto(category);
    }
    public static List<CategoryDto> convertFromCategory(List<Category> categoryList) {
        return categoryList.stream()
                .map(o -> CategoryDto.convertFromCategory(o))
                .collect(Collectors.toCollection(ArrayList::new));

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
