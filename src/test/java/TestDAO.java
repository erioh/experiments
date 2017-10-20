import com.demenkov.dao.IUserDAO;
import com.demenkov.datatypes.User;
import com.demenkov.dao.UserDAO;
import com.demenkov.services.WebService;
import com.demenkov.web.templater.PageGenerator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sdemenkov on 24.07.2017.
 */
public class TestDAO {
    Connection connection;
    @BeforeClass
    public static void init() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Sdemenkov");
    }

    @Test
    public void addUserTest() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Sdemenkov");
        User expectedUser = new User("Name1", new Date(680400000));
        UserDAO userDAO = new UserDAO("jdbc:mysql://localhost:3306/mysql", "root", "Sdemenkov");
        int id = userDAO.addNewUser(expectedUser);
        PreparedStatement statement = connection.prepareStatement("select * from web_users where id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        User actualUser = new User(resultSet.getInt("ID"), resultSet.getString("NAME"), (java.util.Date) resultSet.getDate("DATE_OF_BIRTH"));
        System.out.println(expectedUser);
        System.out.println(actualUser.getDateOfBirth().getTime());
        Assert.assertTrue(expectedUser.equals(actualUser));
    }

    @Test
    public void deleteUserTest() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Sdemenkov");
    }

    @Test
    public void getListOfUsersTest() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Sdemenkov");
    }








}
