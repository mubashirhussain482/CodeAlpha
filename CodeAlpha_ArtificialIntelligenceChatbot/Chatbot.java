package aichatbot;
import java.util.Random;
public class Chatbot {
    private Random random = new Random();
    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase().trim();
        userInput = userInput.replaceAll("[^a-zA-Z0-9 ]", "");
        if (userInput.contains("hello") || userInput.equals("hi") || userInput.contains("hey")) {
            String[] responses = {
                "Hello! How can I help you?",
                "Hi! What would you like to know?",
                "Hey! How can I assist you?"
            };
            return responses[random.nextInt(responses.length)];
        }
        else if (userInput.contains("how are you")) {
            return "I'm doing great! Thanks for asking.";
        }
        else if (userInput.contains("your name") || userInput.contains("who are you")) {
            return "My name is AI Chatbot.";
        }
        else if (userInput.contains("what can you do") || userInput.contains("your abilities")) {
            return "I can answer frequently asked questions about AI, Java, OOP, programming, and databases.";
        }
        else if (userInput.contains("chatbot")) {
            return "A chatbot is a computer program designed to communicate with users through text or voice.";
        }
        else if (userInput.equals("ai") || userInput.contains("artificial intelligence")) {
            return "AI stands for Artificial Intelligence. It enables computers to perform tasks that normally require human intelligence.";
        }
        else if (userInput.contains("java")) {
            return "Java is a high-level, object-oriented programming language.";
        }
        else if (userInput.contains("oop") || userInput.contains("object oriented programming")) {
            return "OOP stands for Object-Oriented Programming. It is a programming approach based on classes and objects.";
        }
        else if (userInput.contains("programming")) {
            return "Programming is the process of creating instructions that tell a computer how to perform a task.";
        }
        else if (userInput.contains("class")) {
            return "A class is a blueprint for creating objects in object-oriented programming.";
        }
        else if (userInput.contains("object")) {
            return "An object is an instance of a class that contains data and behavior.";
        }
        else if (userInput.contains("jdbc")) {
            return "JDBC stands for Java Database Connectivity. It allows Java applications to connect to and interact with databases.";
        }
        else if (userInput.contains("sql")) {
            return "SQL stands for Structured Query Language. It is used to communicate with and manage relational databases.";
        }
        else if (userInput.contains("database")) {
            return "A database is an organized collection of data that can be stored, managed, and retrieved efficiently.";
        }
        else if (userInput.contains("good morning")) {
            return "Good morning! How can I help you today?";
        }
        else if (userInput.contains("good afternoon")) {
            return "Good afternoon! How can I help you?";
        }
        else if (userInput.contains("good evening")) {
            return "Good evening! How can I help you?";
        }
        else if (userInput.contains("thank")) {
            return "You're welcome!";
        }
        else if (userInput.contains("bye")||userInput.contains("goodbye")||userInput.contains("see you")) {
            return "Goodbye! Have a nice day.";
        }
        else {
            return "Sorry, I don't understand that question. You can ask me about AI, Java, OOP, programming, databases, or chatbots.";
        }
    }
}
