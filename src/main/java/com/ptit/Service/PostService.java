package com.ptit.Service;

import com.ptit.Entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
     Page<Post> findAllByOrderByIdPostDesc(int pageNum);

    Post getPostbyIdPost(int id);
    }
