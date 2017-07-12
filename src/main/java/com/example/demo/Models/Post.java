package com.example.demo.Models;
import com.cloudinary.StoredFile;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Controller;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by daylinhenry on 7/11/17.
 */

@Entity
public class Post {

    @LazyCollection(LazyCollectionOption.FALSE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int like;
    private String image;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Collection<User> users;


    public StoredFile getUpload() {
        StoredFile file = new StoredFile();
        file.setPreloadedFile(image);
        return file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }



}
