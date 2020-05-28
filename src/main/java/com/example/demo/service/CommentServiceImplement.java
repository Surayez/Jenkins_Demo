package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplement implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> retrieveAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment getComment(int commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.get();
    }

    @Override
    public List<Comment> getCommentByBlogId(String blogId){
        List<Comment> commentList = commentRepository.findByBlogId(blogId);
        return commentList;
    }

    @Override
    public void saveComment(Comment comment) {
        Date currentDate = new Date();
        comment.setCreatedAt(currentDate);
        comment.setUpdatedAt(currentDate);
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment, int commentId) {
        Comment prevComment = getComment(commentId);
        prevComment.setEmail(comment.getEmail());
        prevComment.setName(comment.getName());
        prevComment.setCommentText(comment.getCommentText());
        prevComment.setUpdatedAt(new Date());
        commentRepository.save(prevComment);
    }

    @Override
    public void deleteComment(int commentId) {
        List<Comment> childComments = commentRepository.findByParent(commentId);
        commentRepository.deleteById(commentId);
        if (commentId != 0 && childComments.size() != 0) {
            for(Comment com: childComments){
                deleteComment(com.getCommentId());
            }
        }
    }

    @Override
    public void upvoteComment(int commentId){
        Comment comment = getComment(commentId);
        comment.setVotes(comment.getVotes() + 1);
        commentRepository.save(comment);
    }

    @Override
    public void downvoteComment(int commentId){
        Comment comment = getComment(commentId);
        comment.setVotes(comment.getVotes() - 1);
        commentRepository.save(comment);
    }

}
