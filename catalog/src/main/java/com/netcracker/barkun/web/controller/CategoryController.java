package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.service.CategoryService;
import com.netcracker.barkun.web.controller.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping
    public Optional<CategoryDto> get(@PathVariable("id") Long id) {
        Optional<Category> categoryById = categoryService.getCategoryById(id);
        Optional<CategoryDto> categoryDto = Optional.of(CategoryDto.convertFromCategory(categoryById.get()));
        return categoryDto;
    }

    @GetMapping
    public Iterable<CategoryDto> getAll() {
        List<Category> allCategory = (List<Category>) categoryService.getAllCategory();
        return CategoryDto.convertFromCategory(allCategory);
    }

    @PostMapping
    public CategoryDto save(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.save(Category.convertFromCategoryDto(categoryDto));
        return CategoryDto.convertFromCategory(category);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/list")
    @PostMapping
    public Iterable<CategoryDto> save(@RequestBody List<CategoryDto> categoryDtoList) {
        List<Category> categories = (List<Category>) categoryService.save(Category.convertFromCategoryDto(categoryDtoList));
        return CategoryDto.convertFromCategory(categories);
    }

    @PutMapping
    public CategoryDto update(@RequestBody CategoryDto newCategory) {
        Category category = categoryService.updateCategory(Category.convertFromCategoryDto(newCategory));
        return CategoryDto.convertFromCategory(category);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        categoryService.removeCategory(id);
    }
}
