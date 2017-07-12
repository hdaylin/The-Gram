package com.example.demo.Models;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by daylinhenry on 7/11/17.
 */
public class Follow {

    private int id;
    private int follower;
    private int following;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
