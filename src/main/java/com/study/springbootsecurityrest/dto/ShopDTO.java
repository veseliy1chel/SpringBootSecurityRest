package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.NotEmpty;

public class ShopDTO {
    @NotEmpty(message = "Name must be not null")
    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
