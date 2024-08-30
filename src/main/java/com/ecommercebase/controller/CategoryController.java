package com.ecommercebase.controller;

import com.ecommercebase.repository.db.entity.Category;
import com.ecommercebase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{name}/children")
    public ResponseEntity<List<Category>> getChildCategories(@PathVariable String name) {
        List<Category> childCategories = categoryService.getChildCategories(name);
        return !childCategories.isEmpty() ? ResponseEntity.ok(childCategories) : ResponseEntity.notFound().build();
    }
}