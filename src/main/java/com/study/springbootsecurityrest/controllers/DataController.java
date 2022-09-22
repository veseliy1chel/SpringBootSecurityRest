package com.study.springbootsecurityrest.controllers;

import com.study.springbootsecurityrest.dto.ProductDTO;
import com.study.springbootsecurityrest.dto.ShopDTO;
import com.study.springbootsecurityrest.models.Product;
import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.services.AdminService;
import com.study.springbootsecurityrest.services.ProductService;
import com.study.springbootsecurityrest.services.ShopService;
import com.study.springbootsecurityrest.util.ProductValidator;
import com.study.springbootsecurityrest.util.ShopValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.naming.NameNotFoundException;
import javax.validation.Valid;
import java.util.Map;
@RestController
public class DataController {
        private final ModelMapper modelMapper;
        private final AdminService adminService;
        private final ShopService shopService;
        private final ProductService productService;

        private final ShopValidator shopValidator;

        private final ProductValidator productValidator;

        @Autowired
        public DataController(AdminService adminService,ProductService productService
                ,ShopService shopService,ProductValidator productValidator,ShopValidator shopValidator,ModelMapper modelMapper) {
            this.adminService = adminService;
            this.productService=productService;
            this.modelMapper=modelMapper;
            this.shopValidator=shopValidator;
            this.productValidator=productValidator;
            this.shopService= shopService;
        }



        @PostMapping("/add/shop")
        public Map<String, String> performShop(@RequestBody @Valid ShopDTO shopDTO, BindingResult bindingResult) {
            adminService.doAdminStuff();
            Shop shop = convertToShop(shopDTO);


            shopValidator.validate(shop, bindingResult);

            if (bindingResult.hasErrors()) {
                return Map.of("message", "Ошибка!");
            }

            shopService.register(shop);
            return Map.of("message","успех!");

        }
    @RequestMapping(value = "/shop/{shop_id}/product", method = RequestMethod.POST)
    public Map<String, String> performProduct(@RequestBody @Valid ProductDTO productDTO, @PathVariable(value = "shop_id") Long shop_id, BindingResult bindingResult) {
        adminService.doAdminStuff();
        Product product = convertToProduct(productDTO);

        try {
            product.setShop(shopService.loadShopById(shop_id).getShop());
        } catch (NameNotFoundException e) {
            return Map.of("message","shop have wrong id");
        }
        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors()) {
            return Map.of("message", "Ошибка!");
        }
        productService.register(product);
        return Map.of("message","успех!");

    }
    public Shop convertToShop(ShopDTO shopDTO) {
        return this.modelMapper.map(shopDTO, Shop.class);
    }
    public Product convertToProduct(ProductDTO productDTO) {
        return this.modelMapper.map(productDTO, Product.class);
    }

}
