/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.mysql.MyJspHelper;
import io.muic.ooc.webapp.mysql.MySql;
import io.muic.ooc.webapp.service.SecurityService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class UserServlet extends HttpServlet {

    private SecurityService securityService;
    String message;
    MySql mysql = new MySql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (securityService.isAuthorized(req)) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/addUser.jsp");
            rd.include(req, resp);}
            else {
                resp.sendRedirect("/login");
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            message = "username or password can not be blank";
            req.setAttribute("info", message);
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/addUser.jsp");
            rd.include(req, resp);
        } else {
            try {
                boolean userNameExist = false;
                ArrayList<String> resultSet = MyJspHelper.getResultSetAsArray();
                for (int i = 0; i < resultSet.size(); i++) {
                    String userFromDB = resultSet.get(i);
                    if (StringUtils.equals(username.toLowerCase(), userFromDB.toLowerCase())) {
                        userNameExist = true;
                    }
                }
                if (userNameExist) {
                    message = "username already exitsts: " + username;
                    req.setAttribute("error", message);
                    RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/addUser.jsp");
                    rd.include(req, resp);
                } else {
                    mysql.addUser(username, password);
                    resp.sendRedirect("/index.jsp");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }


}
