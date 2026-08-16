import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebServer {

    private static Chatbot chatbot = new Chatbot();
    private static GeminiService gemini;

    public static void main(String[] args) throws Exception {

        try {
            gemini = new GeminiService();
            System.out.println("Gemini AI connected successfully.");
        } catch (Exception e) {
            System.out.println("Gemini AI is not available.");
            System.out.println("Reason: " + e.getMessage());
        }

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),
                0
        );

        server.createContext("/", WebServer::handleFrontend);
        server.createContext("/api/chat", WebServer::handleChat);

        server.setExecutor(null);

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       GNIOT STUDENT SUPPORT CHATBOT");
        System.out.println("==============================================");
        System.out.println("Server started successfully!");
        System.out.println("Open: http://localhost:8080");
        System.out.println("Press Ctrl + C to stop the server.");
        System.out.println("==============================================");

        server.start();
    }

    private static void handleFrontend(HttpExchange exchange) throws IOException {

        String requestPath = exchange.getRequestURI().getPath();

        if (requestPath.equals("/")) {
            requestPath = "/index.html";
        }

        Path filePath = Paths.get(
                "src",
                "main",
                "resources",
                "frontend",
                requestPath.substring(1)
        );

        if (!Files.exists(filePath)) {

            String response = "404 - File Not Found";

            exchange.sendResponseHeaders(404, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes(StandardCharsets.UTF_8));
            }

            return;
        }

        String contentType = getContentType(filePath);

        byte[] fileBytes = Files.readAllBytes(filePath);

        exchange.getResponseHeaders().set(
                "Content-Type",
                contentType
        );

        exchange.sendResponseHeaders(
                200,
                fileBytes.length
        );

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(fileBytes);
        }
    }

    private static String getContentType(Path path) {

        String fileName = path.toString().toLowerCase();

        if (fileName.endsWith(".html")) {
            return "text/html; charset=UTF-8";
        }

        if (fileName.endsWith(".css")) {
            return "text/css; charset=UTF-8";
        }

        if (fileName.endsWith(".js")) {
            return "application/javascript; charset=UTF-8";
        }

        return "text/plain; charset=UTF-8";
    }

    private static void handleChat(HttpExchange exchange) throws IOException {

        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {

            sendJson(
                    exchange,
                    405,
                    "{\"error\":\"Method not allowed\"}"
            );

            return;
        }

        String requestBody = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
        );

        String question = extractQuestion(requestBody);

        if (question == null || question.trim().isEmpty()) {

            sendJson(
                    exchange,
                    400,
                    "{\"error\":\"Please enter a question.\"}"
            );

            return;
        }

        question = question.trim();

        String response = chatbot.getResponse(question);

        /*
         * If the local GNIOT chatbot does not know the answer,
         * send the question to Gemini.
         */
        if (response.startsWith("Sorry")) {

            if (gemini != null) {

                try {

                    response = gemini.askGemini(
                            "You are a simple and friendly AI assistant "
                            + "for college students. "
                            + "Answer the question clearly in 3 to 5 short sentences. "
                            + "Use simple language that a college student can understand. "
                            + "Do not give unnecessary details. "
                            + "Do not mention GNIOT, its courses, facilities, events, "
                            + "or activities unless the student specifically asks "
                            + "about GNIOT. "
                            + "For general questions, give only a general answer. "
                            + "Do not invent GNIOT facts. "
                            + "If you do not know a specific GNIOT fact, tell the "
                            + "student to check the official GNIOT website. "
                            + "\n\nStudent question: " + question
                    );

                } catch (Exception e) {

                    response =
                            "Sorry, I could not connect to the AI service right now.";
                }

            } else {

                response =
                        "The AI service is currently unavailable. "
                        + "Please check your Gemini API configuration.";
            }
        }

        String jsonResponse =
                "{\"response\":\"" + escapeJson(response) + "\"}";

        sendJson(
                exchange,
                200,
                jsonResponse
        );
    }

    private static String extractQuestion(String json) {

        String key = "\"question\"";

        int keyIndex = json.indexOf(key);

        if (keyIndex == -1) {
            return null;
        }

        int colonIndex = json.indexOf(
                ":",
                keyIndex + key.length()
        );

        if (colonIndex == -1) {
            return null;
        }

        int firstQuote = json.indexOf(
                "\"",
                colonIndex + 1
        );

        if (firstQuote == -1) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        boolean escaped = false;

        for (int i = firstQuote + 1; i < json.length(); i++) {

            char c = json.charAt(i);

            if (escaped) {

                if (c == 'n') {
                    result.append('\n');
                } else if (c == 'r') {
                    result.append('\r');
                } else if (c == 't') {
                    result.append('\t');
                } else {
                    result.append(c);
                }

                escaped = false;

            } else if (c == '\\') {

                escaped = true;

            } else if (c == '"') {

                break;

            } else {

                result.append(c);
            }
        }

        return result.toString();
    }

    private static String escapeJson(String text) {

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }

    private static void sendJson(
            HttpExchange exchange,
            int statusCode,
            String response
    ) throws IOException {

        byte[] bytes = response.getBytes(
                StandardCharsets.UTF_8
        );

        exchange.getResponseHeaders().set(
                "Content-Type",
                "application/json; charset=UTF-8"
        );

        exchange.getResponseHeaders().set(
                "Access-Control-Allow-Origin",
                "*"
        );

        exchange.sendResponseHeaders(
                statusCode,
                bytes.length
        );

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
