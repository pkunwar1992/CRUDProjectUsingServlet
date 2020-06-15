/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import com.prabin.project.db.JdbcTemplate;
import com.prabin.project.entity.Customer;
import com.prabin.project.repository.CustomerRepository;
import com.prabin.project.repository.impl.CustomerRepositoryImpl;

/**
 *
 * @author Prasbin
 */
public class App {
    public static void main(String[] args) {
        try{
            CustomerRepository repository = new CustomerRepositoryImpl();
                     for(Customer customer:repository.findAll()){
                         System.out.println(customer.getFirstName());
            }
           
            // -- Update section block --   
           /* 
           String sql = "update tbl_suppliers set name=? where id=?";
            int result = template.update(sql, new Object[]{
               "Prabin & Sons Suppliers",1
            });
           */
           
           
           // -- Delete Section block --
           /* 
           String sql = "delete from tbl_suppliers where id=?";
            int result = template.update(sql, new Object[]{
                3
            });
          */  
            
         //  System.out.println("Result :" +result);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
