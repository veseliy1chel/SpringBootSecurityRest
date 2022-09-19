package com.study.springbootsecurityrest.services;

import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.repositories.ShopRepository;
import com.study.springbootsecurityrest.security.ShopDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.Optional;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    @Autowired
    ShopService(ShopRepository shopRepository){
        this.shopRepository=shopRepository;
    }
    @Transactional
    public void register(Shop shop) {
        shopRepository.save(shop);
    }
    public ShopDetails loadShopByName(String s) throws NameNotFoundException {
        Optional<Shop> shop = shopRepository.findByName(s);

        if (shop.isEmpty())
            throw new NameNotFoundException("Shop not found");

        return new ShopDetails(shop.get());
    }
    public ShopDetails loadShopById(Long shop_id)throws NameNotFoundException{
        Optional<Shop> shop = shopRepository.findById(shop_id.intValue());
        if(shop.isEmpty()) throw new NameNotFoundException("Shop not found");

        return new ShopDetails(shop.get());
    }
}
