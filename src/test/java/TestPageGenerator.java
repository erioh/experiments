import com.demenkov.datatypes.User;
import com.demenkov.web.templater.PageGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergeydemenkov on 25.07.17.
 */
public class TestPageGenerator {
    @Test
    public void pageGeneratorGetIndexPage() {
        PageGenerator pg = PageGenerator.instance();
        Map<String, Object> map = new HashMap<>();
        List<User> listOfUsers = new ArrayList<>();
        Date date = new Date(680400000);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String expactedDate = df.format(date);
        listOfUsers.add(new User ("Test Name 1", date));
        map.put("listOfUsers", listOfUsers);
        String s = pg.getPage("index.html", map);
        Assert.assertTrue(s.contains("Test Name 1"));
        Assert.assertTrue(s.contains(expactedDate));
    }
}
