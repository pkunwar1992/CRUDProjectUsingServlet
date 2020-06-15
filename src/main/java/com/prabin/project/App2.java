/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import com.prabin.project.entity.Customer;
import com.prabin.project.entity.Suppliers;
import com.prabin.project.repository.CustomerRepository;
import com.prabin.project.repository.SupplierRepository;
import com.prabin.project.repository.impl.CustomerRepositoryImpl;
import com.prabin.project.repository.impl.SupplierRepositoryImpl;


/**
 *
 * @author Prasbin
 */
public class App2 {

    public static void main(String[] args) {
        try {
           /* SupplierRepository repository = new SupplierRepositoryImpl();
            for(Suppliers s:repository.findAll()){
                System.out.println(s.getName() + " -> " + s.getContactPerson());
                System.out.println(s.getEmail());
                
            }
           */
           
            CustomerRepository repository = new CustomerRepositoryImpl();
            for(Customer c: repository.findAll()){
                System.out.println(c);
            }
            }catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
        }
    }
}
