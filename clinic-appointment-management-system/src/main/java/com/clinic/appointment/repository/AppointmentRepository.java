package com.clinic.appointment.repository;

import com.clinic.appointment.entity.Appointment;
import com.clinic.appointment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);

    List<Appointment> findByUser(User user);
}
