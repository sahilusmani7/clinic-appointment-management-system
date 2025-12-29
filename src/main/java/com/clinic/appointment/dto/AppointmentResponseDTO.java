package com.clinic.appointment.dto;

import java.time.LocalDateTime;

public class AppointmentResponseDTO {

    private Long appointmentId;
    private String doctorName;
    private String specialization;
    private LocalDateTime appointmentTime;

    public AppointmentResponseDTO(Long appointmentId,
                                  String doctorName,
                                  String specialization,
                                  LocalDateTime appointmentTime) {
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.appointmentTime = appointmentTime;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }
}
