package com.adi.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.model.Product;
import com.adi.ecommerce.model.Rating;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.repository.RatingRepository;
import com.adi.ecommerce.request.RatingRequest;

@Service
public class RatingServiceImplementation implements RatingService{

    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImplementation(RatingRepository ratingRepository,ProductService productService){
        this.ratingRepository=ratingRepository;
        this.productService=productService;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Rating rating=new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductRating(Long productId) {
        return ratingRepository.getAllProductRatings(productId);
    }
    
}
