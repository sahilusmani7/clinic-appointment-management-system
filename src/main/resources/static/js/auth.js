const form = document.getElementById("loginForm");
const errorText = document.getElementById("error");

form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const API_BASE =
    window.location.port === "5500"
        ? "http://localhost:8080"
        : window.location.origin;

        const response = await fetch(`${API_BASE}/auth/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        });

        if (!response.ok) {
            throw new Error("Invalid credentials");
        }

        const data = await response.json();
        localStorage.setItem("token", data.token);

        window.location.href = "dashboard.html";

    } catch (err) {
        errorText.innerText = "Login failed";
    }
    function logout() {
        localStorage.removeItem("token");
        window.location.href = "index.html";
    }

});
