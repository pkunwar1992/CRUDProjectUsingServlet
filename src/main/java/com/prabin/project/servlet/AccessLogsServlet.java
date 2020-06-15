/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prasbin
 */
@WebServlet(name = "logs", urlPatterns = "/admin/*")
public class AccessLogsServlet extends HttpServlet implements ServletRequestListener {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp,ServletRequestEvent sre)
            throws ServletException, IOException {
        HttpServletRequest request =(HttpServletRequest) sre.getServletRequest();
        System.out.println("URL :" + request.getRequestURI());
        System.out.println("Method :" + request.getMethod());
        System.out.println("IP :" + request.getRemoteAddr());
        System.out.println("Agent :" + request.getHeader("User-Agent"));
        System.out.println("Date :"+ new Date());
        
        String dburl = "jdbc:mysql://localhost:3306/my_project?useSSL=false";
        String username = "root";
        String password = "root12345";
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = 
                DriverManager.getConnection(dburl, username, password);
        String sql = "insert into access_logs(url,method,agent,ip)"
                + "values(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, request.getRequestURI());
        stmt.setString(2, request.getMethod());
        stmt.setString(3, request.getRemoteAddr());
        stmt.setString(4, request.getHeader("User-Agent"));
        stmt.executeUpdate();
        int result = stmt.executeUpdate();
        System.out.println("Result" +result);
        
       
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
