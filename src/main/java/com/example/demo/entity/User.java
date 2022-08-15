package com.example.demo.entity;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String identity;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(Long id, String userName, String password, String email, String identity) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.identity = identity;
    }

    public User(){

    }
}
