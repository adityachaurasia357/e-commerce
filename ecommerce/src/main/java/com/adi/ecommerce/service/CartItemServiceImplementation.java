package com.adi.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adi.ecommerce.exception.CartItemException;
import com.adi.ecommerce.exception.UserException;
import com.adi.ecommerce.model.Cart;
import com.adi.ecommerce.model.CartItem;
import com.adi.ecommerce.model.Product;
import com.adi.ecommerce.model.User;
import com.adi.ecommerce.repository.CartItemRepository;

@Service
public class CartItemServiceImplementation implements CartItemService{

    private CartItemRepository cartItemRepository;
    private UserService userService;

    public CartItemServiceImplementation(CartItemRepository cartItemRepository,UserService userService){
        this.cartItemRepository=cartItemRepository;
        this.userService=userService;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());

        CartItem createdCartItem=cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartITem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item=findCartItemById(id);
        User user=userService.findUserById(userId);

        if(user.getId().equals(userId)){
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem=cartItemRepository.isCartItemExist(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
       CartItem cartItem=findCartItemById(cartItemId);
       User user=userService.findUserById(cartItem.getUserId());
       User reqUser=userService.findUserById(userId);
       if(user.getId().equals(reqUser.getId())){
        cartItemRepository.deleteById(cartItemId);
       }
       else{
        throw new UserException("You can't remove another user's item");
       }

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
       Optional<CartItem> opt=cartItemRepository.findById(cartItemId);
       if(opt.isPresent()){
        return opt.get();
       }
       throw new CartItemException("Cart item not found by id :"+cartItemId);
    }
    
}
