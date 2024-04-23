package com.ptit.Service;

import com.ptit.Entities.Category;
import com.ptit.Entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
<<<<<<< HEAD
=======

    void save(PostDto postDto);

    void delete(int id);
    void update(PostDto postDto, int id);
>>>>>>> 3d23de938d5a685d033199a3a6bba72ade7dffaa
     Page<Post> findAllByOrderByIdPostDesc(int pageNum);
     Post getPostbyIdPost(int id);
     Page<Post> findByIdCategoryOrderByIdPostDesc(int pageNum, Category category);
    }
