package com.clinic.appointment.repository;

import com.clinic.appointment.entity.MedicineOrder;
import com.clinic.appointment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineOrderRepository extends JpaRepository<MedicineOrder, Long> {
    List<MedicineOrder> findByUser(User user);
}
