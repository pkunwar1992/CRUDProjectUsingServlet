/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Prasbin
 */
@WebListener
public class CSRFListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = req.getSession();
        System.out.println("-------------------------");
        if (session.getAttribute("_csrf_token") == null) {
            UUID id = UUID.randomUUID();
            System.out.println("CSRF TOKEN :" + id);
            session.setAttribute("_csrf_token", UUID.randomUUID());
        } else {
            System.out.println("CSRF TOKEN :"
                    + session.getAttribute("_csrf_token"));
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
