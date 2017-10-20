package com.demenkov.web.pages;

import com.demenkov.services.WebService;
import com.demenkov.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergeydemenkov on 23.07.17.
 */

public class DeleteUserPageServlet extends HttpServlet {
    WebService webService = WebService.instance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("delete_user_responce", "");
        try {
            resp.getWriter().println(PageGenerator.instance().getPage("delete.html", pageVariables));

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
        String strUserId = req.getParameter("userId");
        resp.setContentType("text/html;charset=utf-8");

        if (strUserId == null | strUserId.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_OK);
            pageVariables.put("delete_user_responce", "Please enter Users id");
        } else if (strUserId.matches(".*\\D.*")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            pageVariables.put("delete_user_responce", "Please do not use letters for Id");
        }
        else {
            resp.setStatus(HttpServletResponse.SC_OK);
            int result = webService.deleteUser(Integer.parseInt(strUserId));
            if (result > 0) {
                pageVariables.put("delete_user_responce", "User is deleted");
            } else {
                pageVariables.put("delete_user_responce", "Please use valid users Id");
            }
        }

        resp.getWriter().println(PageGenerator.instance().getPage("delete.html", pageVariables));
    }

}
