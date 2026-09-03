package com.devSuperior.DSCommerci.repositories;

import com.devSuperior.DSCommerci.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
