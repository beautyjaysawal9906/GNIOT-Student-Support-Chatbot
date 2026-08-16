const chatBox = document.getElementById("chatBox");
const userInput = document.getElementById("userInput");
const sendButton = document.getElementById("sendButton");

function addMessage(message, type) {

    const messageDiv = document.createElement("div");
    messageDiv.classList.add("message", type);

    if (type === "bot") {
        messageDiv.innerHTML = `
            <div class="avatar">🤖</div>
            <div class="bubble">${message}</div>
        `;
    } else {
        messageDiv.innerHTML = `
            <div class="bubble">${message}</div>
        `;
    }

    chatBox.appendChild(messageDiv);
    chatBox.scrollTop = chatBox.scrollHeight;
}


// Send question to Java Spring Boot backend
async function sendMessage() {

    const question = userInput.value.trim();

    if (question === "") {
        return;
    }

    addMessage(question, "user");

    userInput.value = "";

    sendButton.disabled = true;
    sendButton.textContent = "Thinking...";

    try {

        const response = await fetch("http://localhost:8080/api/chat", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                question: question
            })
        });

        if (!response.ok) {
            throw new Error("Server error");
        }

        const data = await response.json();

        addMessage(data.answer, "bot");

    } catch (error) {

        console.error(error);

        addMessage(
            "Sorry, I could not connect to the chatbot server. Please make sure the Java backend is running.",
            "bot"
        );

    } finally {

        sendButton.disabled = false;
        sendButton.textContent = "Send ➤";
    }
}


function askQuestion(question) {

    userInput.value = question;

    sendMessage();
}


userInput.addEventListener("keydown", function(event) {

    if (event.key === "Enter") {
        sendMessage();
    }

});