package com.study.springbootsecurityrest.services;

import com.study.springbootsecurityrest.models.Product;
import com.study.springbootsecurityrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Transactional
    public void register(Product product){
        productRepository.save(product);
    }
    public Product loadProductByName(String s) throws NameNotFoundException {
        Optional<Product> product = productRepository.findByName(s);

        if (product.isEmpty())
            throw new NameNotFoundException("Shop not found");

        return product.get();
    }

}
