import com.demenkov.dao.IUserDAO;
import com.demenkov.datatypes.User;
import com.demenkov.services.WebService;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeydemenkov on 25.07.17.
 */
public class TestWebService {
    @Test
    public void WebServiceGetListOfUsersTest() {
//        WebService service = WebService.instance();
//        IUserDAO userDAO = new TestDAO();
//        service.setUserDAO(userDAO);
//        userDAO.addNewUser(new User("1", new Date(1)));
//        userDAO.addNewUser(new User("2", new Date(1)));
//        userDAO.addNewUser(new User("3", new Date(1)));
//        Assert.assertEquals(3, service.getListOfUsers().size());

    }


    class TestUserDAO implements IUserDAO {
        List<User> userList = new ArrayList<>();
        @Override
        public int addNewUser(User user) {
            int before = userList.size();
            userList.add(user);
            int after = userList.size();
            return after - before;
        }

        @Override
        public int deleteUser(int user) {
            int before = userList.size();
            userList.remove(user);
            int after = userList.size();
            return before - after;
        }

        @Override
        public List<User> getUsers() {
            return userList;
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
}
