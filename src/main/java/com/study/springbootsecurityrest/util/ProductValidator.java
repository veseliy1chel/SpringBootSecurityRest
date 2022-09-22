package com.study.springbootsecurityrest.util;

import com.study.springbootsecurityrest.models.Product;
import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.naming.NameNotFoundException;
import javax.naming.SizeLimitExceededException;

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
            if(product.getName().length()<5){
                throw (new SizeLimitExceededException("name was less of 5"));
            }
            if(product.getDescription().length()<10){throw (new SizeLimitExceededException("address was less of 10") );}
            if(product.getPrice()<0){
                throw (new SizeLimitExceededException("Price must be more than 0"));
            }
            productService.loadProductByName(product.getName());


        } catch (SizeLimitExceededException ignored) {
            errors.rejectValue("shop", "", "Product have bad data");
        } catch (NameNotFoundException e) {
            return;
        }
        errors.rejectValue("message","","Product with same name was exists");

    }
}
