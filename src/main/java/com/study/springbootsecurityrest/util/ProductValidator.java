package com.study.springbootsecurityrest.util;

import com.study.springbootsecurityrest.models.Product;
import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.naming.NameNotFoundException;

@Component
public class ProductValidator implements Validator {
    private ProductService productService;

    @Autowired
    public ProductValidator(ProductService productService) {this.productService=productService;}

    @Override
    public boolean supports(Class<?> aClass) {
        return Shop.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o ;
        try {
            productService.loadProductByName(product.getName());
        }catch (NameNotFoundException e) {
            return;
        }
        errors.rejectValue("message","","Product with same name was exists");

    }
}
