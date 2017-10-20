package com.demenkov.dao;

import com.demenkov.datatypes.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by sergeydemenkov on 03.10.17.
 */
public class UserDAOSpring  implements IUserDAO
{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String GET_USERS = "select id, name,DATE_OF_BIRTH from web_users where IFNULL(is_deleted, 'N') = 'N' order by id asc;";
    public static final String ADD_NEW_USER = "insert into web_users( ID, NAME, DATE_OF_BIRTH) values(?, ?, ?);";
    public static final String DELETE_USER_BY_ID = "update web_users set is_deleted = 'Y' where id = ? and IFNULL(is_deleted, 'N') = 'N'";

    @Override
    public int addNewUser(User user) {
        return jdbcTemplate.update(ADD_NEW_USER, new Object[]{user.getId(), user.getName(),user.getDateOfBirth()});
    }

    @Override
    public int deleteUser(int user) {
        return jdbcTemplate.update(DELETE_USER_BY_ID, new Object[] {user});
    }

    @Override
    public List<User> getUsers() {

        return jdbcTemplate.query(GET_USERS, new BeanPropertyRowMapper(User.class));
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
        return null;
    }
}
