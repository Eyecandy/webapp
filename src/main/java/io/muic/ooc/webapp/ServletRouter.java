/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp;

import io.muic.ooc.webapp.servlet.*;
import io.muic.ooc.webapp.service.SecurityService;
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
        initRemoveUse(ctx);
        initEditUser(ctx);
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

    private void initRemoveUse(Context ctx) {
        RemoveUserServlet removeUserServlet = new RemoveUserServlet();
        removeUserServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx,"RemoveUserServlet",removeUserServlet);
        ctx.addServletMapping("/removeUser","RemoveUserServlet");
    }
    private void initEditUser(Context ctx) {
        EditUserServlet editUserServlet = new EditUserServlet();
        editUserServlet.setSecurityService(securityService);
        Tomcat.addServlet(ctx,"EditUserServlet",editUserServlet);
        ctx.addServletMapping("/editUser","EditUserServlet");
    }

}
