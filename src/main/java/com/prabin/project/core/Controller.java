/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prasbin
 */
public abstract class Controller extends HttpServlet {

    protected String viewPrefix = "/WEB-INF/views/";
    protected String viewSuffix = ".jsp";

    protected void view(HttpServletRequest request,
            HttpServletResponse response, String path) throws ServletException,
            IOException {
        request.getRequestDispatcher(viewPrefix + path + viewSuffix)
                .forward(request, response);
    }

}
