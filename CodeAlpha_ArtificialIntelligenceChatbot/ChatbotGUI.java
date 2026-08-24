package aichatbot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;
    private JButton exitButton;
    private Chatbot chatbot;

    public ChatbotGUI() {
        chatbot = new Chatbot();
        frame = new JFrame("AI Chatbot");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        // Input field
        inputField = new JTextField();
        // Buttons
        sendButton = new JButton("Send");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        // Bottom panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);
        
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String userInput = inputField.getText().trim();

                if (userInput.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a message.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                chatArea.append("You: " + userInput + "\n");

                String response = chatbot.getResponse(userInput);

                chatArea.append("Bot: " + response + "\n\n");

                inputField.setText("");
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatArea.setText("");
                inputField.requestFocus();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
            frame.setVisible(true);
            inputField.requestFocus();
            inputField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sendButton.doClick();
                }
            });
        }
    public static void main(String[] args) {
        new ChatbotGUI();
    }
}
