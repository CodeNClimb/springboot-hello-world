package com.api.ecommerce.services;

import com.api.ecommerce.exceptions.CategoryNotUniqueException;
import com.api.ecommerce.exceptions.EntityNotFoundException;
import com.api.ecommerce.models.Category;
import com.api.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements  CategoryService{
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category c) {
        c.setTitle(c.getTitle().toUpperCase());
        if (categoryRepository.getCategoryByTitle(c.getTitle()) != null) {
            throw new CategoryNotUniqueException(c.getTitle());
        }
        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.delete(unwrapCategory(categoryRepository.findById(id), id));

    }

    @Override
    public Set<Category> getAllCategories() {
        return (Set<Category>)categoryRepository.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return unwrapCategory(categoryRepository.findById(id), id);
    }


    public static Category unwrapCategory(Optional<Category> optionalCategory, int categoryId) {
        Category category =  optionalCategory.orElse(null);
        if (category == null) {
            throw new EntityNotFoundException(new Category(), categoryId);
        }
        return category;
    }
}
