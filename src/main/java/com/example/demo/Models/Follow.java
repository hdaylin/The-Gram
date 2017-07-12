package com.example.demo.Models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by daylinhenry on 7/11/17.
 */
@Entity
public class Follow {

    @LazyCollection(LazyCollectionOption.FALSE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int follower;
    private int following;

    @ManyToMany(mappedBy = "follows")
    private Collection<User> users;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
