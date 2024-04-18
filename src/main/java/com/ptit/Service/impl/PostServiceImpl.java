package com.ptit.Service.impl;

import com.ptit.Entities.Category;
import com.ptit.Entities.Post;
import com.ptit.Repository.PostRepository;
import com.ptit.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAllByOrderByIdPostDesc(int pageNum) {
        int pageSize = 5;

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        return postRepository.findAllByOrderByIdPostDesc(pageable);
    }

    @Override
    public Post getPostbyIdPost(int id) {
        return postRepository.findPostByIdPost(id);
    }

    @Override
    public Page<Post> findByIdCategoryOrderByIdPostDesc(int pageNum, Category category) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return postRepository.findByIdCategoryOrderByIdPostDesc(pageable,category);
    }
}
