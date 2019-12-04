/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.markov.vkproject.entity;

import java.util.List;

/**
 *
 * @author rodion
 */
public class User {
    private  String id;
    
    private List<Integer> users = null;

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String id) {
        this.id = id;
    }

    

    public User() {
    }
    
}
