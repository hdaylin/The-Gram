package com.example.demo.Models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by daylinhenry on 7/11/17.
 */
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
