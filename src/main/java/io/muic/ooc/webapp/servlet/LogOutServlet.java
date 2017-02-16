package io.muic.ooc.webapp.servlet;
import io.muic.ooc.webapp.service.SecurityService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    private SecurityService securityService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        securityService.logout(req);
        resp.sendRedirect("/login");
    }
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

}
