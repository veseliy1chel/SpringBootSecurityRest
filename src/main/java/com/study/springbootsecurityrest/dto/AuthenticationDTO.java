package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.NotNull;

public class AuthenticationDTO {
    @NotNull(message = "username must be not null")
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
