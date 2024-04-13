package com.ptit.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @Column(name = "Email")
    private String email;


    @Column(name = "User_Name")
    private String userName;


    @Column(name = "Pass_Word")
    private String passWord;

    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy= "email")
    private Set<Comment> comments;


    public User( String userName, String email, String passWord, String role) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }
}