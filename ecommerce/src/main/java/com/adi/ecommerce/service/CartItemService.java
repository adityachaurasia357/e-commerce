package com.adi.ecommerce.service;

import com.adi.ecommerce.exception.CartItemException;
import com.adi.ecommerce.exception.UserException;
import com.adi.ecommerce.model.Cart;
import com.adi.ecommerce.model.CartItem;
import com.adi.ecommerce.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartITem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
