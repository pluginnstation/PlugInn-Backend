package com.plugInnApp.userRegistration.entity;

import jakarta.persistence.*;

@Entity
public class UserLoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "family_name")
    private String family_name;
    @Column(name = "given_name")
    private String given_name;
    public Integer getUserId() {
        return userId;
    }
    @Column(name = "email")
    private String email;
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getFamily_name() {
        return family_name;
    }
    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }
    public String getGiven_name() {
        return given_name;
    }
    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserLoginEntity{" +
                "userId=" + userId +
                ", family_name='" + family_name + '\'' +
                ", given_name='" + given_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
