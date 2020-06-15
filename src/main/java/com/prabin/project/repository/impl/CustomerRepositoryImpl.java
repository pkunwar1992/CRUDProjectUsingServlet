/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.repository.impl;

import com.prabin.project.db.JdbcTemplate;
import com.prabin.project.db.RowMapper;
import com.prabin.project.entity.Customer;
import com.prabin.project.repository.CustomerRepository;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Prasbin
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private JdbcTemplate<Customer> template = new JdbcTemplate<>();

    @Override
    public List<Customer> findAll() throws Exception {
        String sql = "select * from tbl_customers";
        return template.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNo(rs.getString("contact_no"));
                customer.setCreatedDate(rs.getDate("created_date"));
                customer.setStatus(rs.getBoolean("status"));
                return customer;
            }
        });
    }

    @Override
    public Customer findbyId(int id) throws Exception {
        String sql = "select * from tbl_customers where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs) throws Exception {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setContactNo(rs.getString("contact_no"));
                customer.setCreatedDate(rs.getDate("created_date"));
                customer.setStatus(rs.getBoolean("status"));
                return customer;
            }
        });
    }

    @Override
    public int insert(Customer model) throws Exception {
        String sql = "insert into tbl_customers(first_name,last_name,email,"
                + "contact_no,status)values(?,?,?,?,?)";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(),
            model.getContactNo(), model.isStatus()
        });
    }

    @Override
    public int update(Customer model) throws Exception {
        String sql = "update tbl_customers set first_name=?,last_name=?,"
                + "email=?,contact_no=?,status=? where id=?";

        return template.update(sql, new Object[]{
            model.getFirstName(), model.getLastName(), model.getEmail(),
            model.getContactNo(), model.isStatus(), model.getId()
        });
    }

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "delete from tbl_customers where id=?";
        return template.update(sql, new Object[]{
            id
        });
    }

}
