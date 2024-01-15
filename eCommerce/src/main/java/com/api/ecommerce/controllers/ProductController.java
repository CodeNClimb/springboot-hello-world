package com.api.ecommerce.controllers;

import com.api.ecommerce.dto.ReviewDTO;
import com.api.ecommerce.models.Product;
import com.api.ecommerce.models.Review;
import com.api.ecommerce.services.ProductServiceImpl;
import com.api.ecommerce.services.ReviewServiceImpl;
import com.api.ecommerce.services.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;


@Tag(name = "Product Controller", description = "Create products and write reviews for them.")
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    ProductServiceImpl productService;
    ReviewServiceImpl reviewService;
    UserServiceImpl userService;
    @Operation(summary = "Returns the product with the specified id")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return  new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }
    @Operation(summary = "Returns all products in the database")
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @Operation(summary = "Deletes the product with the speicifed id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "Adds a product to the database")
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }
    @Operation(summary = "Associates a review with the product specified with the id")
    @PostMapping("/{productId}/{username}/review")
    public ResponseEntity<ReviewDTO> reviewProduct(@Valid @RequestBody  Review review, @PathVariable int productId, @PathVariable String username) {
        System.out.println(review.getText());
        Product p = productService.getProduct(productId);
        p.getReviews().add(review);
        productService.addProduct(p);
        review.setProduct(p);
        review.setUser(userService.getUser(username));
        reviewService.addReview(review);
        
        return new ResponseEntity<>(new ReviewDTO(
               review.getId(),
               review.getTitle(),
               review.getText(),
               username
        ), HttpStatus.OK);
    }
    @Operation(summary = "Returns all reviews associated with the specified product id")
    @GetMapping("/{productId}/reviews/all")
    public ResponseEntity<List<ReviewDTO>> getAllReviews(@PathVariable int productId) {
        List<ReviewDTO> reviews = new ArrayList<>();
        for (Review review: productService.getProduct(productId).getReviews()) {
            reviews.add(
                new ReviewDTO(
                    review.getId(),
                    review.getTitle(),
                    review.getText(),
                    review.getUser().getUsername()
                )
            );
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
