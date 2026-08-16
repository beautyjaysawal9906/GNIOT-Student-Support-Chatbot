import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(scanBasePackages = "com.student")
@RestController
@CrossOrigin
public class ChatbotApplication {

    private final Chatbot chatbot = new Chatbot();
    private GeminiService geminiService;

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
    }

    @PostMapping("/api/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {

        String question = request.get("question");

        Map<String, String> response = new HashMap<>();

        if (question == null || question.trim().isEmpty()) {
            response.put("answer", "Please enter a question.");
            return response;
        }

        String answer = chatbot.getResponse(question);

        // If the local chatbot does not know the answer,
        // try Gemini.
        if (answer.startsWith("Sorry")) {

            try {

                if (geminiService == null) {
                    geminiService = new GeminiService();
                }

                answer = geminiService.askGemini(
                        "You are a simple and friendly AI assistant "
                        + "for college students. "
                        + "Answer clearly in 3 to 5 short sentences. "
                        + "Use simple language.\n\n"
                        + "Student question: " + question
                );

            } catch (Exception e) {

                answer = "Sorry, I could not connect to the AI service right now.";
            }
        }

        response.put("answer", answer);

        return response;
    }
}
