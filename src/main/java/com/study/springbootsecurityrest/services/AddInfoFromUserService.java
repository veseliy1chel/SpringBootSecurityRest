package com.study.springbootsecurityrest.services;

import com.study.springbootsecurityrest.models.Person;
import com.study.springbootsecurityrest.models.Product;
import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.repositories.ProductRepository;
import com.study.springbootsecurityrest.repositories.ShopRepository;
import com.study.springbootsecurityrest.security.PersonDetails;
import com.study.springbootsecurityrest.security.ShopDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.Optional;

@Service
public class AddInfoFromUserService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;



    @Transactional
    public void registerProduct(Product product, String shopName) {
        int id = new ShopDetails(shopRepository.findByName(shopName).get()).getId();
        productRepository.save(product);
    }

    @Autowired
    public AddInfoFromUserService(ShopRepository shopRepository,ProductRepository productRepository) {
        this.shopRepository=shopRepository;
        this.productRepository=productRepository;
    }

    @Transactional
    public void registerShop(Shop shop) {
        shopRepository.save(shop);
    }
    public ShopDetails loadShopByName(String s) throws NameNotFoundException {
        Optional<Shop> shop = shopRepository.findByName(s);

        if (shop.isEmpty())
            throw new NameNotFoundException("Shop not found");

        return new ShopDetails(shop.get());
    }
}
