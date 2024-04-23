package com.ptit.Service.impl;

import com.ptit.Dto.CommentDto;
import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import com.ptit.Repository.CommentRepository;
import com.ptit.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(CommentDto commentDto) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = date.format(formatter);
        Comment comment = new Comment(commentDto.getContentCmt(), commentDto.getUser(), commentDto.getPost(),formattedDateTime);
        commentRepository.save(comment);
    }

//    @Override
//    public void delete(int id){
//        commentRepository.deleteByIdCmt(id);
//    }
    @Override
    public Comment getCommentByIdCmt(int idCmt) {
        return commentRepository.findCommentByIdCmt(idCmt);
    }

    @Override
    public List<Comment> findByIdPostOrderByIdCmtDesc(Post idPost) {
        return commentRepository.findByIdPostOrderByIdCmtDesc(idPost);
    }

    @Override
    public void delete(Comment comment){
        commentRepository.delete(comment);
    }
}
