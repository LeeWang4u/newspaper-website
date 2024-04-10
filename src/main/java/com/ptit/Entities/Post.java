package com.ptit.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import java.sql.Timestamp;

@Entity
@Table(name="Posts")
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_Post")
    private String idPost;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content_Post")
    private String contentPost;

    @Column(name = "Image")
    private String image;

    @Column(name = "TimePost")
    private Timestamp timePost;

    @OneToOne
    @JoinColumn(name="Email")
    //   @Column(name = "ID_User")
    private User email;

    @ManyToOne
    @JoinColumn(name="ID_Category")
    private Category idCategory;

    @OneToMany(mappedBy= "idPost")
    private Set<Comment> comments;

    public Post() {

    }
    public Post(String title, String contentPost, String image, Timestamp  timePost, User email, Category idCategory) {
        this.title = title;
        this.contentPost = contentPost;
        this.image = image;
        this.timePost = timePost;
        this.email = email;
        this.idCategory = idCategory;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp  getTimePost() {
        return timePost;
    }

    public void setTimePost(Timestamp  timePost) {
        this.timePost = timePost;
    }

    public User getEmail() {
        return email;
    }

    public void setEmail(User email) {
        this.email = email;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }
}
