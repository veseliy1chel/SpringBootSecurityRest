package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.NotEmpty;

public class ProductDTO {
    @NotEmpty(message = "Name must be not null")
    private String name;

    private String description;

    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
