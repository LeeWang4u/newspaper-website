package com.ptit.Service.impl;

import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import com.ptit.Repository.CommentRepository;
import com.ptit.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment getCommentByIdCmt(int idCmt) {
        return commentRepository.findCommentByIdCmt(idCmt);
    }

    @Override
    public List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost) {
        return commentRepository.findByIdPostOrderByIdCmtDesc(idPost);
    }
}
