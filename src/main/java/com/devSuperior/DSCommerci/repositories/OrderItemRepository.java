package com.devSuperior.DSCommerci.repositories;

import com.devSuperior.DSCommerci.entities.OrderItem;
import com.devSuperior.DSCommerci.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
