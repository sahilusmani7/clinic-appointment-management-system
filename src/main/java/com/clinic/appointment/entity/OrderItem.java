package com.clinic.appointment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MedicineOrder order;

    @ManyToOne
    private Medicine medicine;

    private int quantity;
    private double price;

    public OrderItem() {}

    public OrderItem(MedicineOrder order, Medicine medicine, int quantity, double price) {
        this.order = order;
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() { return id; }
    public Medicine getMedicine() { return medicine; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}
