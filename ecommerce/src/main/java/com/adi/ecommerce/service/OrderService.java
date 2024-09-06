package com.adi.ecommerce.service;

import java.util.List;

import com.adi.ecommerce.exception.OrderException;
import com.adi.ecommerce.model.Address;
import com.adi.ecommerce.model.Order;
import com.adi.ecommerce.model.User;

public interface OrderService {


    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> userOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order cancelledOrder(Long orderId) throws OrderException;
    public List<Order> getAllOrders();
    public void deleteOrder(Long orderId)throws OrderException;
}
