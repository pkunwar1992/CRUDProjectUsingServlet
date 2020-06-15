/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.reader;

import com.prabin.project.entity.Customer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Prasbin
 */
public class CustomerCSVReader {

    public List<Customer> read(String file) throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                Customer customer = new Customer();
                if (tokenizer.hasMoreTokens()) {
                    customer.setFirstName(tokenizer.nextToken());
                }
                if (tokenizer.hasMoreTokens()) {
                    customer.setLastName(tokenizer.nextToken());
                }
                if (tokenizer.hasMoreTokens()) {
                    customer.setEmail(tokenizer.nextToken());
                }
                if (tokenizer.hasMoreTokens()) {
                    customer.setContactNo(tokenizer.nextToken());
                }
               customers.add(customer);

            }

        }
        return customers;
    }

}
