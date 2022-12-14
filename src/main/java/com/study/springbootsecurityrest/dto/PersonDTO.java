package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.NotEmpty;

public class PersonDTO {
    @NotEmpty(message = "Username mustn`t be null")

    private String username;
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
