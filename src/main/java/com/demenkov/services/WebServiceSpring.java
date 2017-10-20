package com.demenkov.services;

import com.demenkov.dao.IUserDAO;
import com.demenkov.datatypes.User;

import java.util.List;

/**
 * Created by sergeydemenkov on 03.10.17.
 */

public class WebServiceSpring implements IWebService {

    IUserDAO userDAO;

    @Override
    public List<User> getListOfUsers() {
        return userDAO.getUsers();
    }

    @Override
    public int addUser(User user) {
        return userDAO.addNewUser(user);
    }

    @Override
    public int deleteUser(int user) {
        return 0;
    }
}
