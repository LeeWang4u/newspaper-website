package com.ptit.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.sql.Timestamp;

@Entity
@Table(name="Posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_Post")
    private int idPost;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content_Post")
    private String contentPost;

    @Column(name = "Image")
    private String image;


    @Column(name = "Time_Post")


    private Timestamp timePost;

    @OneToOne
    @JoinColumn(name="Email")
    //   @Column(name = "ID_User")
    private User email;

    @ManyToOne
    @JoinColumn(name="ID_Category")
    private Category idCategory;

    @OneToMany(mappedBy= "idPost",  fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public Post(String title, String contentPost, String image, Timestamp  timePost, User email, Category idCategory) {
        this.title = title;
        this.contentPost = contentPost;
        this.image = image;
        this.timePost = timePost;
        this.email = email;
        this.idCategory = idCategory;
    }

}
