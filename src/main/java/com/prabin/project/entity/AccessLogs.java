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
public class AccessLogs {
    private int id;
    private String url,method,agent,ip;
    private Date createdDate;

    public AccessLogs() {
    }

    public AccessLogs(int id, String url, String method, String agent, String ip, Date createdDate) {
        this.id = id;
        this.url = url;
        this.method = method;
        this.agent = agent;
        this.ip = ip;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "AccessLogs{" + "id=" + id + ", url=" + url + ", method=" + method + ", agent=" + agent + ", ip=" + ip + ", createdDate=" + createdDate + '}';
    }
    
    
}
