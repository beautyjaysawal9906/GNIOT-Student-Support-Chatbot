import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GeminiService {

    private Client client;

    public GeminiService() {

        String apiKey = System.getenv("GEMINI_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException("GEMINI_API_KEY is not set.");
        }

        client = Client.builder()
                .apiKey(apiKey)
                .build();
    }

    public String askGemini(String question) {

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.5-flash",
                        question,
                        null
                );

        return response.text();
    }
}