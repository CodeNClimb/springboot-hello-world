package com.api.ecommerce.services;

import com.api.ecommerce.models.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    void deleteProduct(int id);

    Product getProduct(int id);

    List<Product> getAllProducts();
}
