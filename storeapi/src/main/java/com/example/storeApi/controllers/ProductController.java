package com.example.storeApi.controllers;

import com.example.storeApi.models.Product;
import com.example.storeApi.services.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    ProductServiceImpl productService;
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
}
