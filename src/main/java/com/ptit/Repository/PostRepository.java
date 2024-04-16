package com.ptit.Repository;

import com.ptit.Entities.Post;
import com.ptit.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> getAllByIdPost(int idPost);
    Post findPostByIdPost(int idPost);
    Post deletePostByIdPost(int idPost);

    int countAllByIdPost(int idPost);

    @Query("select p from Post p")
    List<Post> getAllPost();

    @Query("SELECT p FROM Post p WHERE p.idCategory = :idCategory")
    List<Post> getAllByIdCategory(int idCategory);
}
