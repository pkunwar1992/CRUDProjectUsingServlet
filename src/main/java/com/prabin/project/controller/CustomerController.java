/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.controller;

import com.prabin.project.core.Controller;
import com.prabin.project.entity.Customer;
import com.prabin.project.repository.CustomerRepository;
import com.prabin.project.repository.impl.CustomerRepositoryImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prasbin
 */
@WebServlet(name = "home", urlPatterns = "/admin/customers/*")
public class CustomerController extends Controller {

    private CustomerRepository repository
            = new CustomerRepositoryImpl();

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
                request.setAttribute("customer", 
                        repository.findbyId(getRequestId(uri)));
            } else if (uri.contains("/delete")) {
                repository.deleteById(getRequestId(uri));
                isRedirect = true;
                response.sendRedirect(request.getContextPath()
                        + "/admin/customers?success");
            } else {
                request.setAttribute("customers",
                        repository.findAll());
                page ="index"; 
            }
            if (!isRedirect) {
                view(request, response, "customers/" +page);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        Customer customer = new Customer();
        int id=0;
        if(request.getParameter("id")!=null){
            id=Integer.parseInt(request.getParameter("id"));
        }
        customer.setId(id);
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        customer.setEmail(request.getParameter("email"));
        customer.setContactNo(request.getParameter("contactNo"));
        customer.setStatus(request.getParameter("status") != null);
        try {
            if(customer.getId()==0){
            repository.insert(customer);
            }else{
                repository.update(customer);  
            }
            response.sendRedirect(request.getContextPath()
                    + "/admin/customers?success");
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
