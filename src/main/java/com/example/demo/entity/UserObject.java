package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TBL_USERS", schema = "BLOG")
public class UserObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", schema = "BLOG")
    @ApiModelProperty(hidden=true)
    @Column(name="USER_ID")
    private int userId;

    @Column(name="FIRST_NAME")
    private String first_name;

    @Column(name="LAST_NAME")
    private String last_name;

    @Column(name="EMAIL")
    private String email;

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


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}