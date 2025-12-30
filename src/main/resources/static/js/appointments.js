const token = localStorage.getItem("token");
const doctorSelect = document.getElementById("doctorSelect");
const message = document.getElementById("message");
function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("cart"); // optional but clean
    window.location.href = "index.html";
}
async function loadDoctors() {
    const response = await fetch("http://localhost:8080/doctors");
    const doctors = await response.json();

    doctors.forEach(doc => {
        const option = document.createElement("option");
        option.value = doc.id;
        option.text = doc.name + " (" + doc.specialization + ")";
        doctorSelect.appendChild(option);
    });
}

async function bookAppointment() {
    const doctorId = doctorSelect.value;
    const time = document.getElementById("appointmentTime").value;

    const response = await fetch(
        `http://localhost:8080/appointments?doctorId=${doctorId}&time=${time}`,
        {
            method: "POST",
            headers: {
                "Authorization": "Bearer " + token
            }
        }
    );

    if (response.ok) {
        message.innerText = "Appointment booked successfully";
        loadAppointments();
    } else {
        const error = await response.text();
        message.innerText = error;
    }
}

async function loadAppointments() {
    const response = await fetch("http://localhost:8080/appointments", {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    const data = await response.json();
    const container = document.getElementById("appointments");
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

loadDoctors();
