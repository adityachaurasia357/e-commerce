package com.adi.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.model.Product;
import com.adi.ecommerce.model.Review;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.repository.ReviewRepository;
import com.adi.ecommerce.request.ReviewRequest;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductService productService;
    public ReviewServiceImplementation(ReviewRepository reviewRepository,ProductService productService){
        this.reviewRepository=reviewRepository;
        this.productService=productService;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Review review=new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews(Long productId) {
        return reviewRepository.getAllProductReviews(productId);
    }
    
}
