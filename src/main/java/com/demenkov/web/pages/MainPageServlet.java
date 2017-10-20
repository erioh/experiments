package com.demenkov.web.pages;

import com.demenkov.services.WebService;
import com.demenkov.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergeydemenkov on 23.07.17.
 */

public class MainPageServlet extends HttpServlet {
    WebService webService = WebService.instance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        try {
            pageVariables.put("listOfUsers", webService.getListOfUsers());
            resp.getWriter().println(PageGenerator.instance().getPage("index.html", pageVariables));

            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }


    }


}
