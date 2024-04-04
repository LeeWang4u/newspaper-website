package com.ptit.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Post")
public class Post {

    @Id
    @Column(name="ID_Post")
    private String idPost;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content_Post")
    private String contentPost;

    @Column(name = "Image")
    private String image;

    @Column(name = "TimePost")
    private Date timePost;

    @OneToOne
    @JoinColumn(name="ID_User")
    //   @Column(name = "ID_User")
    private User idUser;

    @ManyToOne
    @JoinColumn(name="ID_Category")
    private Category idCategory;

    @OneToMany(mappedBy= "idPost")
    private Set<Comment> comments;

    public Post() {

    }
    public Post(String title, String contentPost, String image, Date timePost, User idUser, Category idCategory) {
        this.title = title;
        this.contentPost = contentPost;
        this.image = image;
        this.timePost = timePost;
        this.idUser = idUser;
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

    public Date getTimePost() {
        return timePost;
    }

    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }
}
