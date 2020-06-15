/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Prasbin
 */
public class FileExportFromDb {

    public static void main(String[] args) {
        try {
            String file = "customerdb.csv";
            String dburl = "jdbc:mysql://localhost/my_project";
            String username = "root";
            String password = "root12345";
            String sql = "select * from tbl_customers";

            try (Connection conn = DriverManager.getConnection(dburl, username, password)) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet result = stmt.executeQuery();
                FileWriter writer = new FileWriter(file);
                while (result.next()) {
                    String line=result.getInt("id")+","+
                            result.getString("first_name")+","+
                            result.getString("last_name")+","+
                            result.getString("email")+","+
                            result.getString("contact_no")+"\n";
                    writer.write(line);
                }
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
