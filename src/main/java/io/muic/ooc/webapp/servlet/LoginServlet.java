/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.service.Encryption;
import io.muic.ooc.webapp.service.SecurityService;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author gigadot
 */
public class LoginServlet extends HttpServlet {
    Encryption encryption;
    private SecurityService securityService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
                if (securityService.authenticate(username, password, request)) {
                    response.sendRedirect("/");
                } else {
                    String error = "Wrong username or password.";
                    request.setAttribute("error", error);
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
                    rd.include(request, response);
                }
            } else {
                String error = "Username or password is missing.";
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
    public void setEncryption(Encryption encryption) {this.encryption =encryption;}
}
