package com.devSuperior.DSCommerci.controller;

import com.devSuperior.DSCommerci.dto.ProductDTO;
import com.devSuperior.DSCommerci.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value ="/{id}")
    public ProductDTO findById(@PathVariable Long id){
       return service.findById(id);
    }
}
