package com.api.ecommerce.controllers;

import com.api.ecommerce.models.Category;
import com.api.ecommerce.services.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Get all categories")
    @GetMapping("/all")
    public ResponseEntity<Set<Category>> getAllCategories() {
        Set<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(summary = "Delete a category by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(
            @Parameter(description = "ID of the category to delete") @PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category with ID '" + id + "' successfully deleted.", HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Add a new category")
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(
            @Parameter(description = "Category object to add", required = true, content = @Content(schema = @Schema(implementation = Category.class)))
            @Valid @RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
/* 
    @Operation(summary = "Update a category by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @Parameter(description = "ID of the category to update") @PathVariable int id,
            @Parameter(description = "Updated category object", required = true, content = @Content(schema = @Schema(implementation = Category.class)))
            @Valid @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
*/
    @Operation(summary = "Get a category by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(
            @Parameter(description = "ID of the category to retrieve") @PathVariable int id) {
        Category category = categoryService.getCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
