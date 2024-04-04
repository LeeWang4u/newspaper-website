package com.ptit.Entities;




import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @Column(name="ID_Cmt")
    private String idCmt;

    @Column(name = "Content_Cmt")
    private String ContentCmt;

    @ManyToOne
    @JoinColumn(name="ID_User")
    //  @Column(name = "ID_User")
    private User idUser;

    @ManyToOne
    @JoinColumn(name="ID_Post")
    // @Column(name = "ID_Post")
    private Post idPost;

    public Comment() {

    }

    public Comment(String contentCmt, User idUser, Post idPost) {
        ContentCmt = contentCmt;
        this.idUser = idUser;
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

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }
}
