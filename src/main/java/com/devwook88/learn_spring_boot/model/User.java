package com.devwook88.learn_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel
public class User {
    private int id;
    private String username;
    private String email;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated;

    public User(int id, String username, String email, String name, Date dateCreated) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
