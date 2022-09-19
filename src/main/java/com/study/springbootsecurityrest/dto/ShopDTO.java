package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ShopDTO {

    @Size(min = 8,message = "Name must be more than 8 symbols")
    private String name;


    @Size(min = 20,message = "Shop must be more than 20 symbols")
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
