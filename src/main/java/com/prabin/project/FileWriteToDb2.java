/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import com.prabin.project.db.JdbcTemplate;
import com.prabin.project.entity.Customer;
import com.prabin.project.reader.CustomerCSVReader;

/**
 *
 * @author Prasbin
 */
public class FileWriteToDb2 {

    public static void main(String[] args) {
        try {
            String file = "customers.csv";
            JdbcTemplate template = new JdbcTemplate();
            CustomerCSVReader reader = new CustomerCSVReader();
            String sql = "insert into tbl_customers(first_name,last_name,email,contact_no)"
                    + "values(?,?,?,?)";
            for (Customer customer : reader.read(file)) {
               int result= template.update(sql, new Object[]{
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getContactNo()
                }); 
                System.out.println("Result" +result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
