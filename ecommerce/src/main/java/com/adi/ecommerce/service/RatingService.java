package com.adi.ecommerce.service;

import java.util.List;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.model.Rating;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.request.RatingRequest;


public interface RatingService {
    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductRating(Long productId);
}