package com.clinic.appointment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.clinic.appointment.repository.DoctorRepository;
import com.clinic.appointment.repository.MedicineRepository;
import com.clinic.appointment.entity.Doctor;
import com.clinic.appointment.entity.Medicine;
import com.clinic.appointment.entity.User;
import com.clinic.appointment.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ClinicAppointmentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppointmentManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner seedData(
			DoctorRepository doctorRepo,
			MedicineRepository medicineRepo,
			UserRepository userRepo,
			PasswordEncoder passwordEncoder) {
		return args -> {

			// =========================
			// DEMO USER
			// =========================
			if (userRepo.findByEmail("demo@clinic.com").isEmpty()) {
				User demoUser = new User();
				demoUser.setName("Demo User");
				demoUser.setEmail("demo@clinic.com");
				demoUser.setPassword(passwordEncoder.encode("password"));
				demoUser.setRole("USER");

				userRepo.save(demoUser);
			}

			// =========================
			// DOCTORS
			// =========================
			if (doctorRepo.count() == 0) {
				doctorRepo.saveAll(List.of(
						new Doctor("Dr. Ananya Sharma", "Cardiology"),
						new Doctor("Dr. Rohan Mehta", "Dermatology"),
						new Doctor("Dr. Neha Verma", "General Physician")));
			}

			// =========================
			// MEDICINES
			// =========================
			if (medicineRepo.count() == 0) {
				medicineRepo.saveAll(List.of(
						new Medicine("Paracetamol", "Pain Relief", 30.0, 100, false),
						new Medicine("Amoxicillin", "Antibiotic", 120.0, 50, true),
						new Medicine("Cetirizine", "Allergy", 40.0, 80, false)));
			}
		};
	}
}
