package com.demenkov.web.pages;

import com.demenkov.datatypes.User;
import com.demenkov.services.WebService;
import com.demenkov.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by sergeydemenkov on 23.07.17.
 */

public class AddUserPageServlet extends HttpServlet {
    WebService webService = WebService.instance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("add_user_responce", "");
        try {
            resp.getWriter().println(PageGenerator.instance().getPage("insert.html", pageVariables));

            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        try {
            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(req.getParameter("dateOfBirth"));
            User user = new User(req.getParameter("name"),  dateOfBirth); ;
            resp.setContentType("text/html;charset=utf-8");
            if (user == null) {
                resp.setStatus(HttpServletResponse.SC_OK);
                pageVariables.put("add_user_responce", "Please enter name for new user");
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
                webService.addUser(user);
                pageVariables.put("add_user_responce", "User is added");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        resp.getWriter().println(PageGenerator.instance().getPage("insert.html", pageVariables));
    }

}
