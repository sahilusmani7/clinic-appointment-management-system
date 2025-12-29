const form = document.getElementById("registerForm");
const message = document.getElementById("message");

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/users", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                email: email,
                password: password,
                role: "USER"
            })
        });

        if (!response.ok) {
            throw new Error("Registration failed");
        }

        message.style.color = "green";
        message.innerText = "Registration successful! Redirecting to login...";

        setTimeout(() => {
            window.location.href = "index.html";
        }, 1500);

    } catch (err) {
        message.style.color = "#e74c3c";
        message.innerText = "Email already exists or error occurred";
    }
});
