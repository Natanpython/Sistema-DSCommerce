package com.devSuperior.DSCommerci.repositories;

import com.devSuperior.DSCommerci.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposutory extends JpaRepository<Product, Long> {


}
