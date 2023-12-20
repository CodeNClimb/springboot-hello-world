package com.example.storeApi.repository;

import com.example.storeApi.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Integer> {
}
