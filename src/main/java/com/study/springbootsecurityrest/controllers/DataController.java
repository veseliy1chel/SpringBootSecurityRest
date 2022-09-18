package com.study.springbootsecurityrest.controllers;

import com.study.springbootsecurityrest.dto.AuthenticationDTO;
import com.study.springbootsecurityrest.dto.PersonDTO;
import com.study.springbootsecurityrest.dto.ShopDTO;
import com.study.springbootsecurityrest.models.Person;
import com.study.springbootsecurityrest.models.Shop;
import com.study.springbootsecurityrest.security.PersonDetails;
import com.study.springbootsecurityrest.services.AddInfoFromUserService;
import com.study.springbootsecurityrest.services.AdminService;
import com.study.springbootsecurityrest.util.ShopValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.validation.Valid;
import java.util.Map;
@Controller
public class DataController {
        private final ModelMapper modelMapper;
        private final AdminService adminService;
        private final AddInfoFromUserService infoFromUserService;

        private final ShopValidator shopValidator;

        @Autowired
        public DataController(AdminService adminService,AddInfoFromUserService infoFromUserService,ShopValidator shopValidator,ModelMapper modelMapper) {
            this.adminService = adminService;
            this.infoFromUserService=infoFromUserService;
            this.modelMapper=modelMapper;
            this.shopValidator=shopValidator;
        }



        @ResponseBody
        @PostMapping("/add/shop")
        public Map<String, String> performShop(@RequestBody @Valid ShopDTO shopDTO, BindingResult bindingResult) {
            adminService.doAdminStuff();
            Shop shop = convertToShop(shopDTO);


            shopValidator.validate(shop, bindingResult);

            if (bindingResult.hasErrors()) {
                return Map.of("message", "Ошибка!");
            }

            infoFromUserService.registerShop(shop);
            return Map.of("message","успех!");

        }

        @Bean
        public ViewResolver getViewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            return resolver;
        }
    public Shop convertToShop(ShopDTO shopDTO) {
        return this.modelMapper.map(shopDTO, Shop.class);
    }

}
