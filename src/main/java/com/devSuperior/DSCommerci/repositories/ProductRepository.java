package com.devSuperior.DSCommerci.repositories;

import com.devSuperior.DSCommerci.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
