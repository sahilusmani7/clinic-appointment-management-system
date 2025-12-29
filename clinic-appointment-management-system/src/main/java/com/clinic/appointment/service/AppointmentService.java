package com.clinic.appointment.service;

import com.clinic.appointment.entity.Appointment;
import com.clinic.appointment.entity.Doctor;
import com.clinic.appointment.entity.User;
import com.clinic.appointment.repository.AppointmentRepository;
import com.clinic.appointment.repository.DoctorRepository;
import com.clinic.appointment.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.clinic.appointment.dto.AppointmentResponseDTO;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    public Appointment bookAppointment(Long doctorId, LocalDateTime time) {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (appointmentRepository.existsByDoctorIdAndAppointmentTime(doctorId, time)) {
            throw new RuntimeException("Doctor already booked for this time");
        }

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment(doctor, user, time);
        return appointmentRepository.save(appointment);
    }

    public List<AppointmentResponseDTO> getMyAppointments() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return appointmentRepository.findByUser(user)
                .stream()
                .map(a -> new AppointmentResponseDTO(
                        a.getId(),
                        a.getDoctor().getName(),
                        a.getDoctor().getSpecialization(),
                        a.getAppointmentTime()))
                .collect(Collectors.toList());
    }
}
