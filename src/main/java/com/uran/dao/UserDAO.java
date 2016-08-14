package com.uran.dao;

import com.uran.model.User;

import java.util.List;


public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    Long count();
    List<User> getUsers(int page);
    List<User> getUsersBySearch(String userName);
}
