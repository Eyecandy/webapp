/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.exceptions.MySQLDataException;
import io.muic.ooc.webapp.mysql.MySql;
import org.apache.commons.lang.StringUtils;


public class SecurityService {

    private MySql mySql= new MySql();
    
    public boolean isAuthorized(HttpServletRequest request)  throws Exception {
        String username = (String) request.getSession()
                .getAttribute("username");

        return username != null && mySql.checkIfUserExist(username);}


    
    public boolean authenticate(String username, String password, HttpServletRequest request) throws Exception {

        boolean isMatched = mySql.validateLogin(username,password);
        if (isMatched) {
            request.getSession().setAttribute("username", username);
            return true;
        } else {
            return false;
        }
    }


    
    public void logout(HttpServletRequest request) {
        System.out.println("Log out");
        request.getSession().invalidate();
    }
    
}
