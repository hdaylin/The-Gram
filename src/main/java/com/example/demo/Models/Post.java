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


    private int likes;
    private String image;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comments>comments;


    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
