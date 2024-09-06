package com.adi.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adi.ecommerce.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
