package com.adi.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adi.ecommerce.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{
    
}
