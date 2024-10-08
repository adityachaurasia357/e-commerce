package com.adi.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.exception.UserException;
import com.adi.ecommerce.model.Review;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.request.ReviewRequest;
import com.adi.ecommerce.service.ReviewService;
import com.adi.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
            @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Review review = reviewService.createReview(req, user);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Review>> getProductReview(@PathVariable Long prductId)
            throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReviews(prductId);
        return new ResponseEntity<>(reviews, HttpStatus.ACCEPTED);
    }
}
