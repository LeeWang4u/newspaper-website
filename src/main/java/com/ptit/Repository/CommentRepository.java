package com.ptit.Repository;

import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findCommentByIdCmt(int idCmt);
    List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost);


    void deleteByIdCmt(int id);



  //  List<Comment> getCommentByIdCmt(int id);

    //List<Comment> getAllByIdPost(int id);
}
