package com.devSuperior.DSCommerci.services;

import com.devSuperior.DSCommerci.dto.ProductDTO;
import com.devSuperior.DSCommerci.entities.Product;
import com.devSuperior.DSCommerci.repositories.ProductReposutory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductReposutory repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;
    }


}
