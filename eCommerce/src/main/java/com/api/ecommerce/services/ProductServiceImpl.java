package com.api.ecommerce.services;

import com.api.ecommerce.exceptions.EntityNotFoundException;
import com.api.ecommerce.models.Product;
import com.api.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);

    }



    @Override
    public void deleteProduct(int id) {
        productRepository.delete(unwrapProduct(productRepository.findById(id), id));

    }

    @Override
    public Product getProduct(int id) {
        return unwrapProduct(productRepository.findById(id), id);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>)productRepository.findAll();
    }


    public static Product unwrapProduct(Optional<Product> optionalProduct, int productId) {
        Product product =  optionalProduct.orElse(null);
        if (product == null) {
            throw new EntityNotFoundException(new Product(), productId);
        }
        return product;
    }

}
