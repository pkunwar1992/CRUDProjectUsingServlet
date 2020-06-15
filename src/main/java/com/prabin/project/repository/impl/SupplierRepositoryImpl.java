/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.repository.impl;

import com.prabin.project.db.JdbcTemplate;
import com.prabin.project.db.RowMapper;
import com.prabin.project.entity.Suppliers;
import com.prabin.project.repository.SupplierRepository;
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
public class SupplierRepositoryImpl implements SupplierRepository {

    private JdbcTemplate<Suppliers> template = new JdbcTemplate();

    @Override
    public int insert(Suppliers suppliers) throws Exception {
        String sql = "insert into tbl_suppliers(name,email,contact_no,"
                + "contact_person,address)values(?,?,?,?,?)";

        return template.update(sql, new Object[]{
            suppliers.getName(), suppliers.getEmail(), suppliers.getContactNo(),
            suppliers.getContactPerson(), suppliers.getAddress()
        });
    }

    @Override
    public int update(Suppliers suppliers) throws Exception {
        String sql = "update tbl_suppliers set name=?,email=?,contact_no=?,"
                + "contact_person=?,address=? ,status=? where id=?";

        return template.update(sql, new Object[]{
            suppliers.getName(), suppliers.getEmail(), suppliers.getContactNo(),
            suppliers.getContactPerson(), suppliers.getAddress(), suppliers.isStatus(),
            suppliers.getId()
        });
    }

    @Override
    public Suppliers findbyId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "delete from tbl_suppliers where id=?";
        return template.update(sql, new Object[]{
            id
        });
    }

    @Override
    public List<Suppliers> findAll() throws Exception {
      String sql = "select * from tbl_suppliers";
      return template.query(sql, new RowMapper<Suppliers>() {
          @Override
          public Suppliers mapRow(ResultSet rs) throws Exception {
              Suppliers suppliers = new Suppliers();
                suppliers.setId(rs.getInt("id"));
                suppliers.setName(rs.getString("name"));
                suppliers.setEmail(rs.getString("email"));
                suppliers.setContactNo(rs.getString("contact_no"));
                suppliers.setContactPerson(rs.getString("contact_person"));
                suppliers.setAddress(rs.getString("address"));
                suppliers.setCreatedDate(rs.getDate("created_date"));
                suppliers.setStatus(rs.getBoolean("status"));
                return suppliers;
          }
      });
    }
}
