package com.study.springbootsecurityrest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDTO {
    @Size(min = 5,message = "Size must be more than 5 symbols")
    private String name;

    @Size(min = 10,message = "Description must be more than 10 symbols")
    private String description;

    @Min(value = 0,message = "only positive num")
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
