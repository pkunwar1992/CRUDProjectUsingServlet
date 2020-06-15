/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prasbin
 */
public class JdbcTemplate<T> {

    private Connection getConnection() throws Exception {
        String dburl = "jdbc:mysql://localhost:3306/my_project?useSSL=false";
        String username = "root";
        String password = "root12345";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dburl, username, password);
    }

    public List<T> query(String sql, RowMapper<T> mapper) throws Exception {
        List<T> rows = new ArrayList<>();
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                rows.add(mapper.mapRow(result));
            }
        }
        return rows;
    }

    public T queryForObject(String sql, Object[] params,
            RowMapper<T> mapper) throws Exception {
        T row = null;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            setParameters(stmt, params);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                row = mapper.mapRow(result);
            }
        }
        return row;
    }

    private void setParameters(PreparedStatement stmt,
            Object[] params) throws Exception {
        int counter = 1;
        for (Object param : params) {
            stmt.setObject(counter, param);
            counter++;
        }
    }

    public int update(String sql, Object[] params) throws Exception {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            int counter = 1;
            setParameters(stmt, params);
            return stmt.executeUpdate();
        }
    }
}
