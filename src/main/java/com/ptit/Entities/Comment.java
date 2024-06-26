package com.ptit.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Comments")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_Cmt")
    private int idCmt;

    @Column(name = "Content_Cmt")
    private String ContentCmt;

    @Column(name = "Time_Cmt")
    private String timeCmt;



    @ManyToOne
    @JoinColumn(name="Email")
    //  @Column(name = "ID_User")
    private User email;

    @ManyToOne
    @JoinColumn(name="ID_Post")
    // @Column(name = "ID_Post")
    private Post idPost;



    public Comment(String contentCmt, User email, Post idPost,String timeCmt) {
        ContentCmt = contentCmt;
        this.email = email;
        this.idPost = idPost;
        this.timeCmt = timeCmt;
    }


}

