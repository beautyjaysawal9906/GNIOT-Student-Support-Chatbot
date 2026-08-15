import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Chatbot chatbot = new Chatbot();
        GeminiService gemini = new GeminiService();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your course: ");
        String course = sc.nextLine();

        System.out.print("Enter your year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Enter your semester: ");
        int semester = Integer.parseInt(sc.nextLine());

        Student student = new Student(name, course, year, semester);

        System.out.println("\n=================================");
        System.out.println("     GNIOT STUDENT SUPPORT CHATBOT");
        System.out.println("=================================");

        System.out.println("Hello! How can I help you?");
        System.out.println("Type 'help' to see available services.");
        System.out.println("Type 'bye' or 'exit' to close the chatbot.");

        student.displayStudentInfo();

        while (true) {

            System.out.print("\nYou: ");

            String question = sc.nextLine();

            if (question.trim().isEmpty()) {
                System.out.println("Bot: Please enter a question.");
                continue;
            }

            if (question.equalsIgnoreCase("bye") ||
                question.equalsIgnoreCase("exit")) {

                System.out.println("Bot: Thank you! Have a great day!");
                break;
            }

            // First check our GNIOT chatbot
            String response = chatbot.getResponse(question);

            // If chatbot doesn't know the answer, use Gemini
            if (response.startsWith("Sorry")) {

                try {

                    System.out.println("Bot: Let me think...");

                    response = gemini.askGemini(
                        "You are a simple and friendly AI assistant for college students. "
                        + "Answer the question clearly in 3 to 5 short sentences. "
                        + "Use simple language that a college student can understand. "
                        + "Do not give unnecessary details. "
                        + "Do not mention GNIOT, its courses, facilities, events, or "
                        + "activities unless the student specifically asks about GNIOT. "
                        + "For general questions, give only a general answer. "
                        + "Do not invent GNIOT facts. "
                        + "If you do not know a specific GNIOT fact, tell the student "
                        + "to check the official GNIOT website.\n\n"
                        + "Student question: " + question
                    );

                } catch (Exception e) {

                    System.out.println("AI Error: " + e.getMessage());
                    response = "Sorry, I could not connect to the AI service right now.";
                }
            }

            System.out.println("Bot: " + response);
        }

        sc.close();
    }
}