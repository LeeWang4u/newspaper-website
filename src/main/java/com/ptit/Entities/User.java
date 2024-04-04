package com.ptit.Entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity

@Table(name="User")


public class User {
    @Id
    @Column(name="ID_User")
    private String idUser;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PassWord")
    private String passWord;

    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy= "idUser")
    private Set<Comment> comments;

    public User() {

    }

    public User( String userName, String email, String passWord, String role) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

//    public User(String ID_User, String userName, String email, String passWord, String role) {
//        this.ID_User = ID_User;
//        this.userName = userName;
//        this.email = email;
//        this.passWord = passWord;
//        this.role = role;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getID_User() {
        return idUser;
    }

    public void setID_User(String ID_User) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
