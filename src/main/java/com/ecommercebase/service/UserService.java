package com.ecommercebase.service;

import com.ecommercebase.repository.db.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(String username);

    public User createUser(User user);

}
