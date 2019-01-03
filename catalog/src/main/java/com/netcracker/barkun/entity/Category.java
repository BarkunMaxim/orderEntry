package com.netcracker.barkun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.barkun.web.controller.dto.CategoryDto;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Offer> offerList;

    public Category() {
    }

    public Category(String name, List<Offer> offerList) {
        this.name = name;
        this.offerList = offerList;
    }

    private Category(CategoryDto categoryDto) {
        this.setId(categoryDto.getId());
        this.name = categoryDto.getName();
    }

    public static Category convertFromCategoryDto(CategoryDto categoryDto) {
        return new Category(categoryDto);
    }

    public static List<Category> convertFromCategoryDto(List<CategoryDto> categoryDtoList) {
        return categoryDtoList.stream()
                .map(o -> Category.convertFromCategoryDto(o))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public List<Offer> getOffer() {
        return offerList;
    }

    public void setOffer(List<Offer> offerList) {
        this.offerList = offerList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Category category = (Category) obj;

        return Objects.equals(name, category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "value=" + name +
                '}';
    }
}
