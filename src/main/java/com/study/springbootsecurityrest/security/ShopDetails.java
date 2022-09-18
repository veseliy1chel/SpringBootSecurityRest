package com.study.springbootsecurityrest.security;

import com.study.springbootsecurityrest.models.Shop;

public class ShopDetails {
    private final Shop shop;

    public ShopDetails(Shop shop){this.shop=shop;}

    public int getId(){return shop.getId();}

}
