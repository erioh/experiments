package com.demenkov.services;

import com.demenkov.dao.IUserDAO;
import com.demenkov.datatypes.User;
import com.demenkov.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by sergeydemenkov on 23.07.17.
 */

public class WebService implements IWebService {
    private static WebService webService;
    private String connectionString = "jdbc:mysql://localhost:3306/mysql";
    private String login = "root";
    private String password = "Sdemenkov";

    public static WebService instance() {
        if (null == webService) {
            webService = new WebService();
        }
        return webService;
    }


    IUserDAO userDAO = new UserDAO(connectionString, login, password);


    public List<User> getListOfUsers() {
        List<User> users = userDAO.getUsers();
        return users;
    }

    public int addUser(User user) {
        int users_id = userDAO.addNewUser(user);
        return users_id;
    }

    public int deleteUser(int user) {
        return userDAO.deleteUser(user);
    }

    private WebService() {

    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
