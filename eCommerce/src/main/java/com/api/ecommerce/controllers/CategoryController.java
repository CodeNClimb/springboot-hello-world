package com.api.ecommerce.controllers;

import com.api.ecommerce.models.Category;
import com.api.ecommerce.services.CategoryServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    CategoryServiceImpl categoryService;

    @GetMapping("/all")
    public ResponseEntity<Set<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category with id '" + id +"' successfully deleted.", HttpStatus.NO_CONTENT );
    }

    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category, @PathVariable int id){
        categoryService.deleteCategory(id);
        category.setId(id);
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }
}
