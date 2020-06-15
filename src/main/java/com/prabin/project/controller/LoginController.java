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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prasbin
 */
@WebServlet(name = "login", urlPatterns = {"/login/*"})
public class LoginController extends Controller {

    private UserRepository repository = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        view(request, response, "login");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       try{
           User user = repository.login(request.getParameter("username"), 
                request.getParameter("password"));
           if(user ==null){
               response.sendRedirect(request.getContextPath()+"login?error");
           }
           else{
               HttpSession session = request.getSession();
               session.setAttribute("isLoggedin", true);
               response.sendRedirect(request.getContextPath()+"/admin/users");
           }
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
           
    }
}
