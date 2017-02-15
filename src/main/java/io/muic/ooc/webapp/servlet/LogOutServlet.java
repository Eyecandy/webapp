package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by joakimnilfjord on 2/15/2017 AD.
 */
public class LogOutServlet extends HttpServlet {
    private SecurityService securityService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }


}
