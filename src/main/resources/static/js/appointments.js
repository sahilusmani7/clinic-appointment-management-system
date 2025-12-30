const API_BASE =
    window.location.port === "5500"
        ? "http://localhost:8080"
        : window.location.origin;
const token = localStorage.getItem("token");

const doctorSelect = document.getElementById("doctorSelect");
const appointmentMessage = document.getElementById("message");

/* =========================
   GLOBAL LOGOUT
========================= */
function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("cart");
    window.location.href = "index.html";
}

/* =========================
   LOAD DOCTORS
========================= */
async function loadDoctors() {
    if (!doctorSelect) return;

    const response = await fetch(`${API_BASE}/doctors`, {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    const doctors = await response.json();

    doctorSelect.innerHTML = "";

    doctors.forEach(doc => {
        const option = document.createElement("option");
        option.value = doc.id;
        option.text = `${doc.name} (${doc.specialization})`;
        doctorSelect.appendChild(option);
    });
}

/* =========================
   BOOK APPOINTMENT
========================= */
async function bookAppointment() {
    const doctorId = doctorSelect.value;
    const time = document.getElementById("appointmentTime").value;

    const response = await fetch(
        `${API_BASE}/appointments?doctorId=${doctorId}&time=${time}`,
        {
            method: "POST",
            headers: {
                "Authorization": "Bearer " + token
            }
        }
    );

    if (response.ok) {
        appointmentMessage.innerText = "Appointment booked successfully";
        loadAppointments();
    } else {
        const error = await response.text();
        appointmentMessage.innerText = error;
    }
}

/* =========================
   LOAD APPOINTMENTS
========================= */
async function loadAppointments() {
    const container = document.getElementById("appointments");
    if (!container) return;

    const response = await fetch(`${API_BASE}/appointments`, {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    const data = await response.json();
    container.innerHTML = "";

    if (data.length === 0) {
        container.innerHTML = "<p>No appointments booked.</p>";
        return;
    }

    data.forEach(app => {
        const card = document.createElement("div");
        card.className = "appointment-card";

        card.innerHTML = `
            <h4>${app.doctorName}</h4>
            <p><strong>Specialization:</strong> ${app.specialization}</p>
            <p><strong>Time:</strong> ${new Date(app.appointmentTime).toLocaleString()}</p>
        `;

        container.appendChild(card);
    });
}

/* =========================
   AUTO LOAD
========================= */
loadDoctors();
loadAppointments();
