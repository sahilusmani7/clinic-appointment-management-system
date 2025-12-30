package com.clinic.appointment.controller;

import com.clinic.appointment.dto.OrderRequestDTO;
import com.clinic.appointment.entity.*;
import com.clinic.appointment.repository.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    private final MedicineOrderRepository orderRepo;
    private final OrderItemRepository itemRepo;
    private final MedicineRepository medicineRepo;
    private final UserRepository userRepo;

    public OrderController(MedicineOrderRepository orderRepo,
            OrderItemRepository itemRepo,
            MedicineRepository medicineRepo,
            UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.medicineRepo = medicineRepo;
        this.userRepo = userRepo;
    }

    @PostMapping
    public MedicineOrder placeOrder(@RequestBody OrderRequestDTO request,
            Authentication authentication) {

        String email = authentication.getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        MedicineOrder order = new MedicineOrder(
                user,
                request.getTotalAmount(),
                OrderStatus.CREATED);

        orderRepo.save(order);

        List<OrderItem> items = new ArrayList<>();

        for (OrderRequestDTO.Item i : request.getItems()) {
            Medicine med = medicineRepo.findById(i.medicineId)
                    .orElseThrow(() -> new RuntimeException("Medicine not found"));

            OrderItem item = new OrderItem(order, med, i.quantity, i.price);
            items.add(item);
        }

        itemRepo.saveAll(items);
        order.setItems(items);

        return order;
    }

    @GetMapping
    public List<MedicineOrder> getMyOrders(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return orderRepo.findByUser(user);
    }

    @PutMapping("/{orderId}/pay")
    public MedicineOrder payOrder(@PathVariable Long orderId,
            Authentication authentication) {

        String email = authentication.getName();
        MedicineOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        order.setStatus(OrderStatus.PAID);
        return orderRepo.save(order);

    }

    @PutMapping("/{orderId}/dispatch")
    public MedicineOrder dispatchOrder(@PathVariable Long orderId,
            Authentication authentication) {

        MedicineOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() != OrderStatus.PAID) {
            throw new RuntimeException("Order not paid yet");
        }

        order.setStatus(OrderStatus.DISPATCHED);
        return orderRepo.save(order);
    }

    @PutMapping("/{orderId}/deliver")
    public MedicineOrder deliverOrder(@PathVariable Long orderId,
            Authentication authentication) {

        MedicineOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() != OrderStatus.DISPATCHED) {
            throw new RuntimeException("Order not dispatched yet");
        }

        order.setStatus(OrderStatus.DELIVERED);
        return orderRepo.save(order);
    }

}
