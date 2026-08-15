# GNIOT Student Support Chatbot

An AI-powered student support chatbot designed to provide students with quick and simple answers about Greater Noida Institute of Technology (GNIOT), academic information, campus facilities, and general student queries.

## 📌 Project Overview

The GNIOT Student Support Chatbot is a Java-based application that combines predefined college information with AI-powered responses.

Students can ask questions about GNIOT or general academic and programming topics, and the chatbot provides relevant and easy-to-understand answers.

## ✨ Features

* GNIOT basic information
* College location and contact details
* College code
* Courses and departments
* College timings
* Attendance requirements
* Admission process
* B.Tech eligibility
* Scholarships
* Library and hostel information
* Placement support
* Student support services
* Examination and timetable information
* Assignment and leave information
* Campus facilities
* Transport, sports, medical and computer lab information
* AI-powered responses for general questions
* Student profile information including name, course, year and semester

## 🛠️ Technologies Used

* Java
* Maven
* Google Gemini API
* Git & GitHub
* Visual Studio Code

## 📂 Project Structure

```text
StudentSupportChatbot/
│
├── pom.xml
├── .gitignore
├── README.md
│
└── src/
    └── main/
        └── java/
            ├── Main.java
            ├── Chatbot.java
            ├── Student.java
            └── GeminiService.java
```

## 🤖 AI Integration

The chatbot uses the Google Gemini API to answer general questions that are not covered by the predefined GNIOT information.

The Gemini API key is accessed through an environment variable:

```text
GEMINI_API_KEY
```

The API key is not stored directly in the source code.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/beautyjaysawal9906/GNIOT-Student-Support-Chatbot.git
```

### 2. Open the project

Open the project folder in Visual Studio Code.

### 3. Set the Gemini API key

Configure the `GEMINI_API_KEY` environment variable on your system.

### 4. Compile the project

```bash
mvn clean compile
```

### 5. Run the chatbot

```bash
mvn exec:java -Dexec.mainClass=Main
```

## 💬 Example Queries

The chatbot can answer questions such as:

* What is GNIOT?
* Where is GNIOT located?
* What courses does GNIOT offer?
* What is the attendance requirement?
* What is the admission process?
* What is the eligibility for B.Tech?
* What facilities does GNIOT provide?
* What is artificial intelligence?
* How can I improve my Java skills?

## 🎯 Project Objective

The main objective of this project is to provide students with a simple and accessible digital assistant for common college-related queries while demonstrating the use of Java, Maven, API integration, and AI technology.

## 👩‍💻 Developer

**Beauty Jaysawal**
B.Tech – Computer Science Engineering
3rd Year | 5th Semester

## 📌 Future Enhancements

* Graphical user interface
* Voice-based interaction
* Database integration
* Student login system
* Real-time college notices
* Improved AI conversation history
* Web-based chatbot interface
