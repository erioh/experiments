package com.demenkov;

import com.demenkov.web.pages.AddUserPageServlet;
import com.demenkov.web.pages.DeleteUserPageServlet;
import com.demenkov.web.pages.MainPageServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by sergeydemenkov on 23.07.17.
 */

public class MyWebServer {

    private MainPageServlet mainPageServlet = new MainPageServlet();
    private AddUserPageServlet addUserPageServlet = new AddUserPageServlet();
    private DeleteUserPageServlet deleteUserPageServlet = new DeleteUserPageServlet();
    Server server = new Server(8080);

    public  void start () throws Exception {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.addServlet(new ServletHolder(mainPageServlet), "/user");
        servletContextHandler.addServlet(new ServletHolder(addUserPageServlet), "/insert");
        servletContextHandler.addServlet(new ServletHolder(deleteUserPageServlet), "/delete");
        servletContextHandler.addServlet(new ServletHolder(mainPageServlet), "/");
        server.setHandler(servletContextHandler);
        server.start();

    }


}
