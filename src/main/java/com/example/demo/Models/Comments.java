package com.example.demo.Models;

import javafx.geometry.Pos;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by daylinhenry on 7/11/17.
 */

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

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



}
