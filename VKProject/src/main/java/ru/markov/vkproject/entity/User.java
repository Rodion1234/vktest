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
    
    private List<User> friendsInComunity = null;

    public List<User> getFriendsInComunity() {
        return friendsInComunity;
    }

    public void setFriendsInComunity(List<User> friendsInComunity) {
        this.friendsInComunity = friendsInComunity;
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

    @Override
    public String toString() {
        String friends = "";
        for (User user : friendsInComunity) {
             friends = friends + user.getId() + ", ";
        }
        return "User{" + "id=" + id + "; friends: "+ friends +"}";
    }
    
    
}
