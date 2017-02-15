/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp;

import io.muic.ooc.webapp.servlet.HomeServlet;
import io.muic.ooc.webapp.service.SecurityService;
import io.muic.ooc.webapp.servlet.LogOutServlet;
import io.muic.ooc.webapp.servlet.LoginServlet;
import io.muic.ooc.webapp.servlet.UserServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author gigadot
 */
public class ServletRouter {
    
    private SecurityService securityService;

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void init(Context ctx) {
        initHome(ctx);
        initLogin(ctx);
        initAddUser(ctx);
        initLogOut(ctx);

    }

    private void initHome(Context ctx) {
        HomeServlet homeServlet = new HomeServlet();
        homeServlet.setSecurityManager(securityService);
        Tomcat.addServlet(ctx, "HomeServlet", homeServlet);
        ctx.addServletMapping("/index.jsp", "HomeServlet");
    }

    private void initLogin(Context ctx) {
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx, "LoginServlet", loginServlet);
        ctx.addServletMapping("/login", "LoginServlet");
    }
    private void initAddUser(Context ctx) {
        UserServlet userServlet = new UserServlet();
        userServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx, "UserServlet", userServlet);
        ctx.addServletMapping("/addUser", "UserServlet");
    }
    private void initLogOut(Context ctx) {
        LogOutServlet logOutServlet = new LogOutServlet();
        logOutServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx,"LogOutServlet",logOutServlet);
        ctx.addServletMapping("/logout","LogOutServlet");
    }


}
