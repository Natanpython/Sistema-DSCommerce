package com.devSuperior.DSCommerci.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    ;

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
    }

    public Long getId() {
        return this.id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
