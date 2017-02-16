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
import java.sql.ResultSet;

/**
 * Created by joakimnilfjord on 2/16/2017 AD.
 */
public class EditUserServlet extends HttpServlet {
    private SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/editUser.jsp");
        rd.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MySql mySql = new MySql();
        try {

            String oldUserName = req.getParameter("current username");
            String  newUserName= req.getParameter("new username");
            String currUser = (String) req.getSession().getAttribute("username");
            ResultSet resultSet = MyJspHelper.getResultSet();
            boolean oldUserNameExist = false;
            boolean newUserNameExist = false;
            if (!StringUtils.equals(currUser.toLowerCase(),oldUserName.toLowerCase())) {
                while (resultSet.next()) {
                    String usernameInDb = resultSet.getString("username");
                    if (StringUtils.equals(usernameInDb.toLowerCase(), oldUserName.toLowerCase())) {
                        oldUserNameExist = true;
                    }
                    if (StringUtils.equals(newUserName.toLowerCase(), usernameInDb.toLowerCase())) {
                        newUserNameExist = true;
                    }
                }

                if (oldUserNameExist && !newUserNameExist) {
                    mySql.editUser(oldUserName.toLowerCase(),newUserName.toLowerCase());
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
        resp.sendRedirect("/");

    }


    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
