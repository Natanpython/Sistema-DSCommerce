package com.devSuperior.DSCommerci.dto;

import com.devSuperior.DSCommerci.entities.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderItemDTO {

    @NotNull(message = "O id do produto é obrigatório.")
    private Long productId;
    private String name;
    private Double price;

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    private Integer quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
