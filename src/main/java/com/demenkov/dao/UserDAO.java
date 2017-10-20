package com.demenkov.dao;

import com.demenkov.datatypes.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeydemenkov on 23.07.17.
 */


public class UserDAO implements IUserDAO{
    public static final String GET_USERS = "select id, name,DATE_OF_BIRTH from web_users where IFNULL(is_deleted, 'N') = 'N' order by id asc;";
    public static final String ADD_NEW_USER = "insert into web_users( ID, NAME, DATE_OF_BIRTH) values(?, ?, ?);";
    public static final String DELETE_USER_BY_ID = "update web_users set is_deleted = 'Y' where id = ? and IFNULL(is_deleted, 'N') = 'N'";
    Connection connection;
    IUserDAO userDAO;

    ;

    public UserDAO(String url, String login, String password)  {
        try {
            this.connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int addNewUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER);


            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDate(3, new Date(user.getDateOfBirth().getTime()) );
            preparedStatement.executeUpdate();
            return user.getId();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int deleteUser(int user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, user);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }


    public List<User> getUsers()  {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = getSQLResultSet(GET_USERS);
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getDate("Date_Of_Birth")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;

    }

    private ResultSet getSQLResultSet(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;

    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void setConnectionString(String connectionString) {

    }

    @Override
    public void setLogin(String login) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public IUserDAO instance() {
//        if (null == userDAO)
//            userDAO = new UserDAO();
//        return userDAO;
        return null;
    }


}
