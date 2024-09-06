package com.adi.ecommerce.service;

import com.adi.ecommerce.exception.UserException;
import com.adi.ecommerce.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

}
