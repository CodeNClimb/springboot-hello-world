package com.example.storeApi.services;

import com.example.storeApi.exceptions.EntityNotFoundException;
import com.example.storeApi.models.Product;
import com.example.storeApi.models.Review;
import com.example.storeApi.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    ReviewRepository reviewRepository;
    @Override
    public Review addReview(Review review) {
        reviewRepository.save(review);
        return review;
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }

    public static Review unwrapReview(Optional<Review> optionalReview, int reviewId) {
        Review review =  optionalReview.orElse(null);
        if (review == null) {
            throw new EntityNotFoundException(new Review(), reviewId);
        }
        return review;
    }



}
