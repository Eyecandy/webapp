/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gigadot
 */
public class SecurityService {
    
    public boolean isAuthorized(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        // do checking
        return false;
    }
    
    public boolean authenticate(HttpServletRequest request) {
        return true;
    }
    
}
