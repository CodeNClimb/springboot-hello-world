package com.api.ecommerce.controllers;

import com.api.ecommerce.dto.ReviewDTO;
import com.api.ecommerce.models.Product;
import com.api.ecommerce.models.Review;
import com.api.ecommerce.services.ProductServiceImpl;
import com.api.ecommerce.services.ReviewServiceImpl;
import com.api.ecommerce.services.UserServiceImpl;

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



@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    ProductServiceImpl productService;
    ReviewServiceImpl reviewService;
    UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return  new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

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
