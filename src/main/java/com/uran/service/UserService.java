package com.uran.service;

import com.uran.model.User;

import java.util.List;

/*
 * Created by URAN on 09.08.2016.
 */

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    Integer count();
    List<User> getUsers(int page);
    List<User> getUsersBySearch(String userName);
}
