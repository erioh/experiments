package com.demenkov.dao;

import com.demenkov.datatypes.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergeydemenkov on 24.07.17.
 */
public interface IUserDAO {
    public int addNewUser(User user);
    public int deleteUser(int user);
    public List<User> getUsers();
    public void setConnectionString(String connectionString);
    public void setLogin(String login);
    public void setPassword(String password);
    public IUserDAO instance();

}
