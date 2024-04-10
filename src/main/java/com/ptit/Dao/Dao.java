package com.ptit.Dao;

import  com.ptit.Entities.*;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface Dao {

    public List<Post> getPost();

    public List<User> getUser();
}
