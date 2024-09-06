package com.adi.ecommerce.service;

import java.util.List;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.model.Review;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.request.ReviewRequest;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReviews(Long productId);
}
