package com.devSuperior.DSCommerci.services;

import com.devSuperior.DSCommerci.dto.CategoryDTO;
import com.devSuperior.DSCommerci.entities.Category;
import com.devSuperior.DSCommerci.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    //Get para todos com o Pageable ele pagina listagens otimo para muitas datos em get all
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }




}
