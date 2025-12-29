package com.clinic.appointment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "appointments",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"doctor_id", "appointmentTime"})
    }
)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    public Appointment() {}

    public Appointment(Doctor doctor, User user, LocalDateTime appointmentTime) {
        this.doctor = doctor;
        this.user = user;
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
