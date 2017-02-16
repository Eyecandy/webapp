/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.mysql.MyJspHelper;
import io.muic.ooc.webapp.service.SecurityService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeServlet extends HttpServlet {
    private SecurityService securityService;

    public void setSecurityManager(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        boolean authorized = securityService.isAuthorized(request);
        if (authorized) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/home.jsp");
            String username = (String) request.getSession().getAttribute("username");
            request.setAttribute("info", "logged in as "+ username);
            HashSet<Object> myMap = MyJspHelper.getHashSet();
            request.setAttribute("myMap",myMap);
            rd.include(request, response);

        } else {
            response.sendRedirect("/login");
        }}
        catch (Exception e) {}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/home.jsp");
            rd.include(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/addUser.jsp");
        rd.include(req, resp);
    }




}
