package com.prolific.software.foodappbackend.model;

import com.prolific.software.foodappbackend.utils.UserTypes;

import javax.persistence.Entity;

@Entity
public class UserAccount extends User {

    private String firstName;
    private String lastName;

    private String email;

    private UserTypes userType;

    public UserAccount() {
    }

    public UserAccount(String username, String password, String token, String firstName, String lastName, String email, UserTypes userType) {
        super(username, password, token);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }
}
