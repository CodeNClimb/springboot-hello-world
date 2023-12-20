package com.example.storeApi.services;

import com.example.storeApi.models.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    void deleteProduct(int id);

    Product getProduct(int id);

    List<Product> getAllProducts();
}
