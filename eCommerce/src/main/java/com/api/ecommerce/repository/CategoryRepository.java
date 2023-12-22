package com.api.ecommerce.repository;

import com.api.ecommerce.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category getCategoryByTitle(String title);
}
