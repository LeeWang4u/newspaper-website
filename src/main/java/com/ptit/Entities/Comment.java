package com.ptit.Entities;




import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_Cmt")
    private String idCmt;

    @Column(name = "Content_Cmt")
    private String ContentCmt;

    @Column(name = "TimeCmt")
    private Timestamp timeCmt;



    @ManyToOne
    @JoinColumn(name="Email")
    //  @Column(name = "ID_User")
    private User email;

    @ManyToOne
    @JoinColumn(name="ID_Post")
    // @Column(name = "ID_Post")
    private Post idPost;

    public Comment() {

    }

    public Comment(String contentCmt, User email, Post idPost) {
        ContentCmt = contentCmt;
        this.email = email;
        this.idPost = idPost;
    }

    public String getIdCmt() {
        return idCmt;
    }

    public void setIdCmt(String idCmt) {
        this.idCmt = idCmt;
    }

    public String getContentCmt() {
        return ContentCmt;
    }

    public void setContentCmt(String contentCmt) {
        ContentCmt = contentCmt;
    }

    public Timestamp getTimeCmt() {
        return timeCmt;
    }

    public void setTimeCmt(Timestamp timeCmt) {
        this.timeCmt = timeCmt;
    }

    public User getEmail() {
        return email;
    }

    public void setEmail(User email) {
        this.email = email;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }
}
