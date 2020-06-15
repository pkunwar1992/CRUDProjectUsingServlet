/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.repository.impl;

import com.prabin.project.db.JdbcTemplate;
import com.prabin.project.db.RowMapper;
import com.prabin.project.entity.User;
import com.prabin.project.repository.UserRepository;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Prasbin
 */
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate<User> template = new JdbcTemplate<>();

    @Override
    public List<User> findAll() throws Exception {
        String sql = "select * from tbl_users";
        return template.query(sql, new UserRowMapper());
    }

    @Override
    public User findbyId(int id) throws Exception {
        String sql = "select * from tbl_users where id=?";
        return template.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public int insert(User model) throws Exception {
        String sql = "insert into tbl_users(username,password,email,"
                + "contact_no,status)values(?,?,?,?,?)";

        return template.update(sql, new Object[]{
            model.getUsername(), model.getPassword(), model.getEmail(),
            model.getContactNo(), model.isStatus()
        });
    }

    @Override
    public int update(User model) throws Exception {
        String sql = "update tbl_users set username=?,password=?,"
                + "email=?,contact_no=?,status=? where id=?";

        return template.update(sql, new Object[]{
            model.getUsername(), model.getPassword(), model.getEmail(),
            model.getContactNo(), model.isStatus(), model.getId()
        });
    }

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "delete from tbl_users where id=?";
        return template.update(sql, new Object[]{
            id
        });
    }

    @Override
    public User login(String username, String password) throws Exception {
        String sql = "select * from tbl_users where username=? "
                + "and password=?";
        return template.queryForObject(sql, new Object[]{
            username, password
        }, new UserRowMapper());
    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs) throws Exception {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setContactNo(rs.getString("contact_no"));
            user.setCreatedDate(rs.getDate("created_date"));
            user.setStatus(rs.getBoolean("status"));
            return user;
        }

    }

}
