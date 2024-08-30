package com.ecommercebase.service;

import com.ecommercebase.repository.db.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category getCategoryByName(String name);
    List<Category> getChildCategories(String name);
}
