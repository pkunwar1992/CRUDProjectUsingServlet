/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author Prasbin
 */
public class FileRead {

    public static void main(String[] args) {
        try {
            String file = "customers.csv";
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line, ",");
                    if (tokenizer.hasMoreTokens()) {
                        System.out.println(tokenizer.nextToken());
                    }
                    if (tokenizer.hasMoreTokens()) {
                        System.out.println(tokenizer.nextToken());
                    }
                    if (tokenizer.hasMoreTokens()) {
                        System.out.println(tokenizer.nextToken());
                    }
                    if (tokenizer.hasMoreTokens()) {
                        System.out.println(tokenizer.nextToken());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
