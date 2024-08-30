package com.ecommercebase.service;

import com.ecommercebase.repository.db.CategoryRepository;
import com.ecommercebase.repository.db.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public List<Category> getChildCategories(String name) {
        // Obtener la categoría principal por ID
        Category parentCategory = categoryRepository.findByCategoryName(name);
        if (parentCategory != null) {
            return categoryRepository.findByParentCategory(parentCategory);
        }
        return List.of();
    }
}
