package com.devSuperior.DSCommerci.services;

import com.devSuperior.DSCommerci.dto.ProductDTO;
import com.devSuperior.DSCommerci.entities.Product;
import com.devSuperior.DSCommerci.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //Get puxar por ID
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    //Get para todos com o Pageable ele pagina listagens otimo para muitas datos em get all
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }


}
