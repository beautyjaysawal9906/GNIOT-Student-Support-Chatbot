const messages = document.getElementById("messages");
const userInput = document.getElementById("userInput");
const sendButton = document.getElementById("sendButton");

// Local student information
const student = {
    name: "Beauty",
    course: "B.Tech",
    year: "3rd Year",
    semester: "5th Semester"
};

document.getElementById("studentName").textContent = student.name;
document.getElementById("studentCourse").textContent = student.course;
document.getElementById("studentYear").textContent = student.year;
document.getElementById("studentSemester").textContent = student.semester;
document.getElementById("profileLetter").textContent =
    student.name.charAt(0).toUpperCase();

userInput.addEventListener("keydown", function(event) {
    if (event.key === "Enter") {
        sendMessage();
    }
});

function sendMessage() {

    const question = userInput.value.trim();

    if (question === "") {
        return;
    }

    addUserMessage(question);

    userInput.value = "";

    showTyping();

    setTimeout(() => {

        removeTyping();

        const response = getBotResponse(question);

        addBotMessage(response);

    }, 600);
}

function quickQuestion(question) {

    userInput.value = question;

    sendMessage();
}

function addUserMessage(text) {

    const message = document.createElement("div");

    message.className = "message user-message";

    message.innerHTML = `
        <div class="avatar">👤</div>
        <div class="bubble">
            <strong>You</strong>
            <p>${escapeHtml(text)}</p>
        </div>
    `;

    messages.appendChild(message);

    scrollToBottom();
}

function addBotMessage(text) {

    const message = document.createElement("div");

    message.className = "message bot-message";

    message.innerHTML = `
        <div class="avatar">🤖</div>
        <div class="bubble">
            <strong>GNIOT Assistant</strong>
            <p>${formatResponse(text)}</p>
        </div>
    `;

    messages.appendChild(message);

    scrollToBottom();
}

function showTyping() {

    const message = document.createElement("div");

    message.id = "typing";

    message.className = "message bot-message";

    message.innerHTML = `
        <div class="avatar">🤖</div>
        <div class="bubble typing">
            GNIOT Assistant is thinking...
        </div>
    `;

    messages.appendChild(message);

    scrollToBottom();
}

function removeTyping() {

    const typing = document.getElementById("typing");

    if (typing) {
        typing.remove();
    }
}

function scrollToBottom() {

    messages.scrollTop = messages.scrollHeight;
}

function clearChat() {

    messages.innerHTML = `
        <div class="message bot-message">
            <div class="avatar">🤖</div>
            <div class="bubble">
                <strong>GNIOT Assistant</strong>
                <p>
                    Chat cleared! 👋 How can I help you today?
                </p>
            </div>
        </div>
    `;
}

/*
 * Temporary frontend response system.
 *
 * This allows the interface to work immediately in the browser.
 * Later, this can be connected directly to the Java/Gemini backend.
 */
function getBotResponse(question) {

    const q = question.toLowerCase().trim();

    if (q === "hi" || q === "hello" || q === "hey") {

        return "Hello! 👋 Welcome to the GNIOT Student Support Chatbot. How can I help you?";
    }

    if (q.includes("help")) {

        return `
            You can ask me about:<br><br>
            • GNIOT information<br>
            • Courses and departments<br>
            • Location and contact<br>
            • Attendance<br>
            • Admission and eligibility<br>
            • Scholarships<br>
            • Placements<br>
            • Library and hostel<br>
            • Campus facilities<br>
            • Exams and timetable<br>
            • General AI and programming questions
        `;
    }

    if (
        q.includes("what is gniot") ||
        q.includes("about gniot") ||
        q.includes("about college")
    ) {

        return "Greater Noida Institute of Technology (GNIOT) is an engineering institute in Greater Noida. It was established in 2001 and is approved by AICTE and affiliated with Dr. A.P.J. Abdul Kalam Technical University (AKTU), Lucknow.";
    }

    if (
        q.includes("college code") ||
        q.includes("gniot code")
    ) {

        return "The College Code of Greater Noida Institute of Technology is 132.";
    }

    if (
        q.includes("where is gniot") ||
        q.includes("location") ||
        q.includes("address")
    ) {

        return "GNIOT is located at Plot No. 7, Knowledge Park-II, Greater Noida, Gautam Buddh Nagar, Uttar Pradesh - 201306.";
    }

    if (
        q.includes("contact") ||
        q.includes("phone") ||
        q.includes("telephone")
    ) {

        return "GNIOT contact numbers are 0120-2328214, 0120-2328215 and 0120-2328216. The toll-free number is 18002746969.";
    }

    if (
        q.includes("course") ||
        q.includes("courses") ||
        q.includes("degree")
    ) {

        return "GNIOT offers B.Tech programs in Computer Science and Engineering, CSE-IoT, CSE-AI & ML, Information Technology, ECE, Civil, Mechanical, Electrical, CSE-Data Science, CSE-AI, CSE-Cyber Security and AI & Data Science. It also offers M.Tech, MBA, MCA and Integrated BCA + MCA programs.";
    }

    if (
        q.includes("computer science") ||
        q.includes("cse")
    ) {

        return "GNIOT offers B.Tech in Computer Science and Engineering along with specializations including AI & ML, Artificial Intelligence, Data Science and Cyber Security.";
    }

    if (
        q.includes("timing") ||
        q.includes("college time") ||
        q.includes("working hours")
    ) {

        return "The institute timings listed by GNIOT are 9:00 AM to 5:00 PM.";
    }

    if (
        q.includes("attendance")
    ) {

        return "According to GNIOT's examination policy, students must maintain a minimum of 75% attendance in each theory paper to be eligible to appear for the University Examination.";
    }

    if (
        q.includes("admission process") ||
        q.includes("how to get admission")
    ) {

        return "For admission-related information, GNIOT provides eligibility criteria, required documents, fee details and admission procedures on its official website. For admission enquiries, students can contact the GNIOT Admission Help Line.";
    }

    if (
        q.includes("eligibility") ||
        q.includes("eligible for btech") ||
        q.includes("btech eligibility")
    ) {

        return "For B.Tech admission, candidates should have passed 10+2 or an equivalent examination with Physics and Mathematics as compulsory subjects and the required optional subject. The minimum marks are 45% for general candidates and 40% for SC/ST candidates.";
    }

    if (
        q.includes("facility") ||
        q.includes("facilities")
    ) {

        return "GNIOT provides several student facilities including a library, computer labs, hostel facilities, cafeteria, sports facilities, transportation and medical facilities.";
    }

    if (
        q.includes("transport")
    ) {

        return "GNIOT provides transportation facilities for students. For current routes, timings and availability, students should contact the college administration.";
    }

    if (
        q.includes("library")
    ) {

        return "GNIOT provides a library facility for students. For current library timings and rules, please check the official college information.";
    }

    if (
        q.includes("hostel")
    ) {

        return "GNIOT provides hostel facilities for students. For current hostel availability, fees and rules, students should contact the college administration.";
    }

    if (
        q.includes("placement") ||
        q.includes("job")
    ) {

        return "GNIOT provides placement and career support for students. For current placement drives, recruiters and opportunities, please check the latest college information.";
    }

    if (
        q.includes("scholarship")
    ) {

        return "GNIOT provides information and support related to scholarships. Students should check the latest scholarship notices for current opportunities.";
    }

    if (
        q.includes("exam") ||
        q.includes("examination")
    ) {

        return "For examination schedules and notices, students should check the latest official GNIOT or AKTU examination notice.";
    }

    if (
        q.includes("timetable") ||
        q.includes("time table")
    ) {

        return "For the latest class timetable, students should check their department notice board or official student portal.";
    }

    if (
        q.includes("assignment") ||
        q.includes("homework")
    ) {

        return "For assignment details, students should contact their subject teacher or check the student portal.";
    }

    if (
        q.includes("artificial intelligence") ||
        q.includes("what is ai")
    ) {

        return "Artificial Intelligence (AI) is a branch of computer science that creates smart systems capable of performing tasks that normally require human intelligence, such as learning, reasoning, problem-solving and understanding language.";
    }

    if (
        q.includes("machine learning") ||
        q.includes("what is ml")
    ) {

        return "Machine Learning (ML) is a branch of Artificial Intelligence that allows computers to learn patterns from data and make predictions or decisions without being explicitly programmed for every situation.";
    }

    if (
        q.includes("java") ||
        q.includes("programming skills") ||
        q.includes("coding skills")
    ) {

        return "To improve your programming skills, practice coding regularly, build small projects, solve problems on platforms such as HackerRank or LeetCode, and focus strongly on programming fundamentals and Object-Oriented Programming.";
    }

    if (
        q.includes("bye") ||
        q.includes("exit")
    ) {

        return "Goodbye! 👋 Best of luck with your studies and your projects!";
    }

    return "I can help you with GNIOT information, courses, attendance, admission, facilities, placements, scholarships, examinations, or general questions about AI, Machine Learning and programming.";
}

function formatResponse(text) {

    return text
        .replace(/\n/g, "<br>")
        .replace(/\*\*(.*?)\*\*/g, "<strong>$1</strong>");
}

function escapeHtml(text) {

    const div = document.createElement("div");

    div.textContent = text;

    return div.innerHTML;
}