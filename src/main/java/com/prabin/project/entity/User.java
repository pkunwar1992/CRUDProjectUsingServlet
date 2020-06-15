/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.entity;

import java.util.Date;

/**
 *
 * @author Prasbin
 */
public class User extends MasterEntity{
    private String username,password,email,contactNo;
    private Date createdDate;
    private boolean status;
    
    public User(){
        
    }
    
    public User(int id){
        super(id);
    }

    public User(String username, String password, String email, String contactNo, Date createdDate, boolean status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactNo = contactNo;
        this.createdDate = createdDate;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", email=" + email + ", contactNo=" + contactNo + ", createdDate=" + createdDate + ", status=" + status + '}';
    }
    
    
}
