package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_COMMENTS", schema = "BLOG")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "com_seq")
    @SequenceGenerator(name = "com_seq", sequenceName = "comment_sequence", schema = "BLOG")
    @ApiModelProperty(hidden=true)
    @Column(name="COMMENT_ID")
    private int commentId;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="COMMENT_text")
    private String commentText;

    @ApiModelProperty(hidden=true)
    @Column(name="VOTES")
    private int votes;

    @Column(name="PARENT")
    private int parent;

    @ApiModelProperty(required = true)
    @Column(name="BLOG_ID")
    private String blogId;

    @ApiModelProperty(hidden=true)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    @CreatedDate
    private Date createdAt;

    @ApiModelProperty(hidden=true)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    @LastModifiedDate
    private Date updatedAt;
    //getters and setters

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}