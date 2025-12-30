package com.clinic.appointment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stockQuantity;

    @Column(nullable = false)
    private boolean prescriptionRequired;

    public Medicine() {}

    public Medicine(String name, String category, double price, int stockQuantity, boolean prescriptionRequired) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.prescriptionRequired = prescriptionRequired;
    }

    // Getters only (read-only for now)
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public boolean isPrescriptionRequired() { return prescriptionRequired; }
}
