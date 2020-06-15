/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prabin.project.repository;

import java.util.List;

/**
 *
 * @author Prasbin
 */
public interface CRUDRepository<T> {
    List<T> findAll() throws Exception;
    T findbyId(int id)throws Exception;
    int insert(T model) throws Exception;
    int update(T model) throws Exception;
    int deleteById(int id) throws Exception;
}
