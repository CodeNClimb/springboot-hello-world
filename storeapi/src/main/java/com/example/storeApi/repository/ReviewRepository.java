package com.example.storeApi.repository;

import com.example.storeApi.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
