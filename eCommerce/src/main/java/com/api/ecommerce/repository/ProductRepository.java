package com.api.ecommerce.repository;

import com.api.ecommerce.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Integer> {
}
