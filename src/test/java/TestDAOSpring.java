import com.demenkov.dao.IUserDAO;
import com.demenkov.dao.UserDAOSpring;
import com.demenkov.datatypes.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeydemenkov on 03.10.17.
 */
public class TestDAOSpring {
    @Test
    public void addUserTest() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        IUserDAO dao = (IUserDAO) applicationContext.getBean("userDAOSpring");
        User expectedUser = new User("Name1", new Date(680400000));
        dao.addNewUser(expectedUser);


    }
    @Test
    public void getUsersTest() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        IUserDAO dao = (IUserDAO) applicationContext.getBean("userDAOSpring");
        List<User> users = dao.getUsers();
        for (User user :
                users) {
            System.out.println(user.getId()+ " " + user.getName() + " "+ user.getDateOfBirth());
        }


    }
}
