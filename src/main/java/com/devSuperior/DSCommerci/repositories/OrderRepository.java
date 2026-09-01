package com.devSuperior.DSCommerci.repositories;

import com.devSuperior.DSCommerci.entities.Order;
import com.devSuperior.DSCommerci.entities.User;
import com.devSuperior.DSCommerci.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
