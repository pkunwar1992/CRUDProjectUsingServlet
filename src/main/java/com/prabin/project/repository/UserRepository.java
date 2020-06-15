/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.repository;

import com.prabin.project.entity.User;

/**
 *
 * @author Prasbin
 */
public interface UserRepository extends CRUDRepository<User> {
    User login(String username,String password) throws Exception;
}
