package com.clinic.appointment.dto;

import java.util.List;

public class OrderRequestDTO {

    public static class Item {
        public Long medicineId;
        public int quantity;
        public double price;
    }

    private List<Item> items;
    private double totalAmount;

    public List<Item> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
}
