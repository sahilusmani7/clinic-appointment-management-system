package com.clinic.appointment.controller;

import com.clinic.appointment.dto.AppointmentResponseDTO;
import com.clinic.appointment.entity.Appointment;
import com.clinic.appointment.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment book(@RequestParam Long doctorId,
            @RequestParam String time) {

        LocalDateTime appointmentTime = LocalDateTime.parse(time);
        return appointmentService.bookAppointment(doctorId, appointmentTime);
    }

    @GetMapping
    public List<AppointmentResponseDTO> myAppointments() {
        return appointmentService.getMyAppointments();
    }

}
