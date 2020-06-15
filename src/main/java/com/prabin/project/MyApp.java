/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import com.prabin.project.entity.Suppliers;
import com.prabin.project.repository.SupplierRepository;
import com.prabin.project.repository.impl.SupplierRepositoryImpl;

/**
 *
 * @author Prasbin
 */
public class MyApp {

    public static void main(String[] args) {
        try {
            SupplierRepository repository = new SupplierRepositoryImpl();
            int result = repository.update(new Suppliers(5, "Rajesh Dai Suppliers", "rajesh.dai@gmail.com",
                    "98520443356", "Rajesh Hamal", "Jupiter"));
            System.out.println("Result :" + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
