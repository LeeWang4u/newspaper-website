package com.ptit.Service;

import com.ptit.Dto.CommentDto;
import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void save(CommentDto commentDto);
    Comment getCommentByIdCmt(int idCmt);
    List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost);

}
