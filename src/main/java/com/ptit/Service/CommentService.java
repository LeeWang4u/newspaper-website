package com.ptit.Service;

import com.ptit.Dto.CommentDto;
import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import com.ptit.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void save(CommentDto commentDto);


  //  void delete(int id);

    void delete(Comment comment);

    Comment getCommentByIdCmt(int idCmt);
    List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost);

    List<Comment> findByEmailOrderByIdCmtDesc(User user);

}
