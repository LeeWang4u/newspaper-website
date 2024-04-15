package com.ptit.Repository;

import com.ptit.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> getAllByIdPost(Integer id);
    Post findPostByIdPost(Integer id);
    Post deletePostByIdPost(Integer id);

    int countAllByIdPost(int id);
    List<Post> getAllByIdCategory(int id);
}
