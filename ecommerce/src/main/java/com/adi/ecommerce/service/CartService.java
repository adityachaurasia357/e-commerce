package com.adi.ecommerce.service;

import com.adi.ecommerce.exception.ProductException;
import com.adi.ecommerce.model.Cart;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
    public Cart findUserCart(Long userId);
}
