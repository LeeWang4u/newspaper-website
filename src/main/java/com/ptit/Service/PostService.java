package com.ptit.Service;

import com.ptit.Dto.PostDto;
import com.ptit.Entities.Category;
import com.ptit.Entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    void save(PostDto postDto);

    void delete(int id);
    void update(PostDto postDto, int id);
     Page<Post> findAllByOrderByIdPostDesc(int pageNum);
     Post getPostbyIdPost(int id);
     Page<Post> findByIdCategoryOrderByIdPostDesc(int pageNum, Category category);
    }
