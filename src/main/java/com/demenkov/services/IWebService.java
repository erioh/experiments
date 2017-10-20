package com.demenkov.services;

import com.demenkov.datatypes.User;

import java.util.List;

/**
 * Created by sergeydemenkov on 24.07.17.
 */
public interface IWebService {
    public List<User> getListOfUsers();
    public int addUser(User user);
    public int deleteUser(int user);

}
