/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.controller;

import com.prabin.project.core.Controller;
import com.prabin.project.entity.User;
import com.prabin.project.repository.UserRepository;
import com.prabin.project.repository.impl.UserRepositoryImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prasbin
 */
@WebServlet(name = "users", urlPatterns = "/admin/users/*")
public class UserController extends Controller {

    private UserRepository repository
            = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        String page = "";
        boolean isRedirect = false;
        try {
            String uri = request.getRequestURI();
            if (uri.contains("/add")) {
                page = "add";
            } else if (uri.contains("/edit")) {
                page = "edit";
                request.setAttribute("user", 
                        repository.findbyId(getRequestId(uri)));
            } else if (uri.contains("/delete")) {
                repository.deleteById(getRequestId(uri));
                isRedirect = true;
                response.sendRedirect(request.getContextPath()
                        + "/admin/users?success");
            } else {
                request.setAttribute("users",
                        repository.findAll());
                page = "index";
            }
            if (!isRedirect) {
                view(request, response,"users/" +page);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        User user = new User();
        int id=0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }
        user.setId(id);
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setContactNo(request.getParameter("contactNo"));
        user.setStatus(request.getParameter("status") != null);
        try {
            if(user.getId()==0){
            repository.insert(user);
            }else{
                repository.update(user);  
            }
            response.sendRedirect(request.getContextPath()
                    + "/admin/users?success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getRequestId(String uri) {
        String[] tokens = uri.split("/");
        String idString = tokens[tokens.length - 1];
        return Integer.parseInt(idString);
    }

}
