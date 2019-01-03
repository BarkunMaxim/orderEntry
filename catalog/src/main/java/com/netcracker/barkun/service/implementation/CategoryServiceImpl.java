package com.netcracker.barkun.service.implementation;

import com.netcracker.barkun.dao.repository.CategoryRepository;
import com.netcracker.barkun.entity.Category;
import com.netcracker.barkun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Iterable<Category> save(List<Category> categoryList) {
        return categoryRepository.saveAll(categoryList);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
