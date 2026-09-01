package com.devSuperior.DSCommerci.controller;

import com.devSuperior.DSCommerci.dto.ProductDTO;
import com.devSuperior.DSCommerci.dto.ProductMinDTO;
import com.devSuperior.DSCommerci.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

//Buscar pelo ID
    @GetMapping(value ="/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
       ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

//Buscar a lista completa
    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>>  findAll(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable){
        Page<ProductMinDTO> dto = service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }

//Criando novo registro com Post
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //Atualizando registro PUT
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value ="/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    //Deletando registro
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
