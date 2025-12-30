const API_BASE =
    window.location.port === "5500"
        ? "http://localhost:8080"
        : window.location.origin;

const form = document.getElementById("registerForm");
const registerMessage = document.getElementById("message");

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch(`${API_BASE}/users`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name,
                email,
                password,
                role: "USER"
            })
        });

        if (!response.ok) {
            throw new Error("Registration failed");
        }

        registerMessage.style.color = "green";
        registerMessage.innerText = "Registration successful! Redirecting...";

        setTimeout(() => {
            window.location.href = "index.html";
        }, 1500);
    } catch (err) {
        registerMessage.style.color = "#e74c3c";
        registerMessage.innerText = "Email already exists or error occurred";
    }
});
