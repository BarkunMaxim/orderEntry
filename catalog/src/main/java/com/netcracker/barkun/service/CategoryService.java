package com.netcracker.barkun.service;

import com.netcracker.barkun.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    Iterable<Category> getAllCategory();

    Iterable<Category> save(List<Category> categoryList);

    Optional<Category> getCategoryById(Long id);

    Category updateCategory(Category category);

    void removeCategory(Long id);
}
