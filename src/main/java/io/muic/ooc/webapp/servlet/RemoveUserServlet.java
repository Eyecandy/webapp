package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.mysql.MySql;
import io.muic.ooc.webapp.service.SecurityService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by joakimnilfjord on 2/15/2017 AD.
 */
public class RemoveUserServlet extends HttpServlet {
    private SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/removeUser.jsp");
        String username = req.getParameter("username");
        req.setAttribute("username",username);
        String msg = "Are you sure you want to delete " + username + "?";
        req.setAttribute("msg", msg);
        rd.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buttonClicked = req.getParameter("buttonClicked");
        if (StringUtils.equals("Yes",buttonClicked)) {
            String currUser = (String) req.getSession().getAttribute("username");
            String username = req.getParameter("username");
            if (!StringUtils.equals(currUser,username)) {
                MySql mysql = new MySql();
                try { mysql.removeUser(username);}
                catch (Exception e) {}
            }
        }
        resp.sendRedirect("/");
    }
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

}
