package com.devSuperior.DSCommerci.entities;

import jakarta.persistence.*;

import java.time.Instant;


@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    public Order() {
    }

    ;

    public Long getId() {
        return this.id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


}
