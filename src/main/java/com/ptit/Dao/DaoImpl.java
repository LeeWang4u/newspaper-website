package com.ptit.Dao;

//import helpers.DBUtils;
import java.util.*;

import  com.ptit.Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {

    private EntityManager entityManager;
    @Autowired
    public DaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Post> getPost(){

        //TypedQuery<Post> query = entityManager.createQuery("from Post", Post.class);
       // List<Post> posts = query.getResultList();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post p JOIN FETCH p.idCategory JOIN FETCH p.email", Post.class);
        List<Post> posts = query.getResultList();

        for (Post post : posts) {
            System.out.println("ID_Post: " + post.getIdPost());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Content_Post: " + post.getContentPost());
            System.out.println("Image: " + post.getImage());
            System.out.println("Time_Post: " + post.getTimePost());
            System.out.println("ID_Category: " + post.getIdCategory());
            System.out.println("Email: " + post.getEmail());
            System.out.println();
        }


        return posts;
    }

    public List<User> getUser(){
        TypedQuery<User> query = entityManager.createQuery(
                "from User",User.class);
        // query.setParameter("data", theId);
        List<User> users = query.getResultList();

        for (User user : users) {
         //   System.out.println("ID_User: " + user.getIdUser());
            System.out.println("User_Name: " + user.getUserName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Role: " + user.getRole());
            System.out.println();
        }
        return users;
    }
}
