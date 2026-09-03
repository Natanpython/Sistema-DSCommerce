package com.devSuperior.DSCommerci.services;


import com.devSuperior.DSCommerci.dto.OrderDTO;
import com.devSuperior.DSCommerci.dto.OrderItemDTO;
import com.devSuperior.DSCommerci.entities.*;
import com.devSuperior.DSCommerci.repositories.OrderItemRepository;
import com.devSuperior.DSCommerci.repositories.OrderRepository;
import com.devSuperior.DSCommerci.repositories.ProductRepository;
import com.devSuperior.DSCommerci.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {


    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    //Get puxar por ID
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new OrderDTO(order);
    }

    @Transactional
    public  OrderDTO insert( OrderDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);

    }
}
