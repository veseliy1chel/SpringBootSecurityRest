package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PersonDTO {
    @NotEmpty(message = "Username mustn`t be null")
    private String username;
    private String password;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
