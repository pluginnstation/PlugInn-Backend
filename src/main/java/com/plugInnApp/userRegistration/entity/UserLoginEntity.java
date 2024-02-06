package com.plugInnApp.userRegistration.entity;

import jakarta.persistence.*;

@Entity
public class UserLoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String lastName;
    String firstName;
    String email;
    String carNumber;
    String carModelDescription;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModelDescription() {
        return carModelDescription;
    }

    public void setCarModelDescription(String carModelDescription) {
        this.carModelDescription = carModelDescription;
    }

    @Override
    public String toString() {
        return "UserLoginEntity{" +
                "userId=" + userId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carModelDescription='" + carModelDescription + '\'' +
                '}';
    }
}
