/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import com.prabin.project.entity.Customer;
import com.prabin.project.reader.CustomerCSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.StringTokenizer;

/**
 *
 * @author Prasbin
 */
public class FileWriteToDb {

    public static void main(String[] args) {
        try {
            String file = "customers.csv";
            String dburl = "jdbc:mysql://localhost/my_project";
            String username = "root";
            String password = "root12345";

            try (Connection conn = DriverManager.getConnection(dburl, username, password)) {
                String sql = "insert into tbl_customers(first_name,last_name,"
                        + "email,contact_no) values(?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                CustomerCSVReader reader = new CustomerCSVReader();
                for(Customer customer : reader.read(file)){
                    System.out.println(customer);
                    stmt.setString(1, customer.getFirstName());
                    stmt.setString(2, customer.getLastName());
                    stmt.setString(3, customer.getEmail());
                    stmt.setString(4, customer.getContactNo());
                    int result = stmt.executeUpdate();
                    System.out.println("Result" +result);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
