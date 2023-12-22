package com.api.ecommerce.services;

import com.api.ecommerce.models.Category;

import java.util.Set;

public interface CategoryService {
    Category addCategory(Category c);

    void deleteCategory(int id);

    Set<Category> getAllCategories();

    Category getCategory(int id);

}
