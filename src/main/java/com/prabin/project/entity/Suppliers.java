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
public class Suppliers extends MasterEntity{
    private String name, email,contactNo,contactPerson,address;
    private Date createdDate;
    private boolean status;

    public Suppliers() {
    }

    public Suppliers(int id) {
        super(id);
    }

    public Suppliers(int id, String name, String email, String contactNo, String contactPerson, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPerson = contactPerson;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    
}
