package com.study.springbootsecurityrest.util;

import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.naming.NameNotFoundException;
import javax.naming.SizeLimitExceededException;

@Component
public class ShopValidator implements Validator {

    private final ShopService shopService;

    @Autowired
    public ShopValidator(ShopService shopService) {
        this.shopService=shopService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Shop.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Shop shop = (Shop) o;


        try {
            if(shop.getName().length()<8){
                throw (new SizeLimitExceededException("name was less of 8"));
            }
            if(shop.getAddress().length()<20){throw (new SizeLimitExceededException("address was less of 20") );}

            shopService.loadShopByName(shop.getName());
        } catch (SizeLimitExceededException ignored) {
            errors.rejectValue("shop", "", "Shop have bad data");


        } catch (NameNotFoundException e) {
            return;
        }
        errors.rejectValue("shop", "", "Shop with same name already exists");
    }
}
