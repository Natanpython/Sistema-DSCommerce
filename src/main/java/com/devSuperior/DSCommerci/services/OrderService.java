package com.devSuperior.DSCommerci.services;


import com.devSuperior.DSCommerci.dto.OrderDTO;
import com.devSuperior.DSCommerci.entities.Order;
import com.devSuperior.DSCommerci.repositories.OrderRepository;
import com.devSuperior.DSCommerci.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {


    @Autowired
    private OrderRepository repository;


    //Get puxar por ID
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new OrderDTO(order);
    }
}
