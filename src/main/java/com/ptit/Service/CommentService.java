package com.ptit.Service;

import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment getCommentByIdCmt(int idCmt);
    List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost);

}
