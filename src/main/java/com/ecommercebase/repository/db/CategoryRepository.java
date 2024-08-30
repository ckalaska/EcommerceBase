package com.ecommercebase.repository.db;

import com.ecommercebase.repository.db.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :categoryName, '%'))")
    Category findByCategoryName(@Param("categoryName") String categoryName);

    List<Category> findByParentCategory(Category parentCategory);
}
