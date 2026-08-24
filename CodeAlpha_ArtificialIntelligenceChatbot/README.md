# **🤖 – ARTIFICIAL INTELLIGENCE CHATBOT -**

---

## **📌 Project Overview**

A GUI-based **Artificial Intelligence Chatbot** developed in Java as part of the **CodeAlpha Java Programming Internship**.

The application provides an interactive communication interface where users can enter questions and receive responses from the chatbot in real time.

The chatbot uses basic **Natural Language Processing (NLP)** techniques such as text normalization, punctuation removal, and keyword-based input processing. It uses a **rule-based response system** to identify frequently asked questions and provide appropriate responses.

The project is developed using **Object-Oriented Programming (OOP)** concepts and a **Java Swing GUI** for user interaction.

---

## **🎯 Project Objectives**

The main objectives of this project are to:

- Create a Java-based chatbot for interactive communication
- Develop a graphical user interface for real-time interaction
- Apply basic Natural Language Processing techniques
- Process and normalize user input
- Identify keywords and phrases from user messages
- Implement rule-based chatbot responses
- Train the chatbot with frequently asked questions and predefined responses
- Handle unknown questions appropriately
- Apply Object-Oriented Programming concepts
- Implement input validation for empty messages

---

## **✨ Features**

### **💬 Interactive Chat**

- Provide real-time communication between the user and chatbot
- Display user messages in the chat area
- Display chatbot responses in the chat area
- Maintain the conversation during the current session
- Allow users to send messages using the **Send** button
- Allow users to send messages by pressing the **Enter** key
- Automatically return focus to the input field after sending a message

### **🧠 Natural Language Processing**

The chatbot performs basic NLP processing on user input:

- Convert input to lowercase
- Remove unnecessary spaces
- Remove punctuation and special characters
- Normalize user input before processing
- Identify important keywords and phrases
- Match user input with predefined rules
- Recognize different ways of asking similar questions

For example:

```text
What is Java?
Tell me about Java
Explain Java
```

can all be recognized as Java-related questions.

### **🤖 Rule-Based Artificial Intelligence**

The chatbot uses predefined rules to determine appropriate responses.

The application analyzes the user's input and checks it against different keywords and phrases.

Examples include:

- Greeting detection
- AI-related questions
- Java-related questions
- OOP-related questions
- Programming-related questions
- Database-related questions
- Chatbot-related questions
- General conversation

### **❓ Frequently Asked Questions**

The chatbot is trained with predefined responses for frequently asked questions about:

- Artificial Intelligence
- Java
- Object-Oriented Programming
- Programming
- Classes
- Objects
- Databases
- SQL
- JDBC
- Chatbots

### **👋 General Conversation**

The chatbot can respond to common conversational messages such as:

- Hello
- Hi
- Hey
- How are you?
- What is your name?
- Who are you?
- What can you do?
- Good morning
- Good afternoon
- Good evening
- Thank you
- Bye
- Goodbye
- See you

### **🔄 Multiple Responses**

The chatbot provides multiple possible responses for greetings.

For example, when the user enters:

```text
Hello
```

the chatbot can randomly select one of several responses.

This makes conversations more natural and prevents the chatbot from giving exactly the same greeting every time.

### **⚠️ Unknown Question Handling**

If the chatbot does not recognize a user's question, it provides a predefined response instead of crashing.

Example:

```text
User: What is quantum physics?

Bot: Sorry, I don't understand that question. You can ask me about AI, Java, OOP, programming, databases, or chatbots.
```

### **🛡️ Input Validation**

- Prevent empty messages
- Display a validation message when the input field is empty
- Trim unnecessary spaces from user input
- Handle unexpected questions without crashing
- Process punctuation and special characters during NLP preprocessing

### **🧹 Clear Chat**

- Clear the complete conversation from the chat area
- Return focus to the input field after clearing the chat

### **🚪 Exit**

- Provide an Exit button
- Close the application when the user selects Exit

---

## **🧑‍💻 Object-Oriented Programming**

The project uses OOP concepts to organize the chatbot application.

### **📦 Classes Used**

- **Chatbot** – Contains the chatbot's response logic, NLP preprocessing, keyword matching, FAQ responses, and rule-based AI functionality.
- **ChatbotGUI** – Provides the Java Swing graphical interface, handles user interaction, displays messages, and connects the GUI with the chatbot.

### **🔹 OOP Concepts Applied**

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- Object interaction
- Data hiding using private fields
- Modular program design

---

## **🖥️ Application Interface**

The application provides a graphical chat interface containing:

```text
========================================
              AI CHATBOT
========================================

Bot: Hello! How can I help you?

You: What is Java?

Bot: Java is a high-level, object-oriented
programming language.

----------------------------------------
[ Enter your message here... ] [ Send ]

             [ Clear ] [ Exit ]
========================================
```

The user can enter a message in the input field and either click **Send** or press **Enter** to receive a chatbot response.

---

## **🧠 Chatbot Knowledge Base**

The chatbot contains predefined responses for frequently asked questions and common conversation.

### **Artificial Intelligence**

```text
User: What is AI?

Bot: AI stands for Artificial Intelligence. It enables computers to perform tasks that normally require human intelligence.
```

### **Java**

```text
User: What is Java?

Bot: Java is a high-level, object-oriented programming language.
```

### **OOP**

```text
User: What is OOP?

Bot: OOP stands for Object-Oriented Programming. It is a programming approach based on classes and objects.
```

### **Database**

```text
User: What is a database?

Bot: A database is an organized collection of data that can be stored, managed, and retrieved efficiently.
```

### **SQL**

```text
User: What is SQL?

Bot: SQL stands for Structured Query Language. It is used to communicate with and manage relational databases.
```

### **JDBC**

```text
User: What is JDBC?

Bot: JDBC stands for Java Database Connectivity. It allows Java applications to connect to and interact with databases.
```

---

## **🔤 NLP Processing**

The chatbot performs basic input preprocessing before checking the user's message.

The input is:

1. Converted to lowercase
2. Trimmed to remove unnecessary spaces
3. Processed to remove punctuation and special characters
4. Checked for relevant keywords and phrases
5. Matched against predefined chatbot rules

For example:

```text
User Input:
"What is Java?!"

        ↓

Lowercase:
"what is java?!"

        ↓

Remove punctuation:
"what is java"

        ↓

Keyword Detection:
"java"

        ↓

Response:
"Java is a high-level, object-oriented programming language."
```

---

## **💾 Data Storage**

This project does **not** use a database or external file storage.

The chatbot's questions, keywords, rules, and responses are defined directly in the Java program.

Therefore:

- No external database is required
- No external files are required
- No internet connection is required
- No external API is required
- The chatbot works completely locally

---

## **🛠️ Technologies Used**

- **Java**
- **Java Swing**
- **Object-Oriented Programming (OOP)**
- **Natural Language Processing (Basic NLP)**
- **Rule-Based Artificial Intelligence**
- **JFrame**
- **JTextArea**
- **JTextField**
- **JButton**
- **JScrollPane**
- **ActionListener**
- **Random**
- **Input Validation**
- **NetBeans IDE**
- **Git & GitHub**

---

## **▶️ How to Run**

### **1. Clone or download the repository**

Open the project in a Java-supported IDE such as **NetBeans, IntelliJ IDEA, or Eclipse**.

### **2. Open the project**

Make sure both Java classes are located inside the `aichatbot` package.

### **3. Run the GUI class**

Run:

```text
ChatbotGUI.java
```

The chatbot window will appear.

### **4. Start chatting**

Enter a question into the input field and click **Send** or press **Enter**.

Example:

```text
You: What is Java?

Bot: Java is a high-level, object-oriented programming language.
```

---

## **🧪 Testing Examples**

The chatbot was tested with different types of inputs.

### **Greeting Tests**

```text
Hello
Hi
Hey
```

### **AI Tests**

```text
What is AI?
Tell me about artificial intelligence
```

### **Java Tests**

```text
What is Java?
Tell me about Java
Explain Java
```

### **OOP Tests**

```text
What is OOP?
Explain OOP
What is object oriented programming?
```

### **Programming Tests**

```text
What is programming?
Tell me about programming
```

### **Database Tests**

```text
What is a database?
What is SQL?
What is JDBC?
```

### **General Conversation Tests**

```text
How are you?
Who are you?
What can you do?
Thank you
Goodbye
```

### **Unknown Input Test**

```text
User: What is quantum physics?

Bot: Sorry, I don't understand that question. You can ask me about AI, Java, OOP, programming, databases, or chatbots.
```

### **Empty Input Test**

```text
User: [Empty]

Bot: Please enter a message.
```

### **GUI Tests**

- Send button tested
- Enter key tested
- Clear button tested
- Exit button tested
- Input field focus tested
- Multiple messages tested
- Different question variations tested

---

## **📂 Project Structure**

```text
CodeAlpha
│
└── aichatbot
    │
    ├── Chatbot.java
    └── ChatbotGUI.java
```

### **Chatbot.java**

Contains:

- NLP preprocessing
- Keyword detection
- Rule-based response logic
- Frequently asked questions
- General conversation responses
- Unknown question handling
- Multiple greeting responses

### **ChatbotGUI.java**

Contains:

- Main application window
- Chat area
- Input field
- Send button
- Clear button
- Exit button
- Action listeners
- User input handling
- Chatbot interaction

---

## **🎓 Learning Outcomes**

Through this project, practical experience was gained in:

- Developing Java-based GUI applications
- Using Java Swing components
- Implementing interactive chatbot functionality
- Applying basic Natural Language Processing techniques
- Processing and normalizing user input
- Implementing keyword-based intent recognition
- Developing rule-based AI logic
- Creating predefined FAQ responses
- Applying Object-Oriented Programming concepts
- Implementing input validation
- Handling unknown user input
- Working with event-driven programming
- Using Java `Random` for multiple responses
- Testing interactive GUI applications
- Organizing and managing projects using Git and GitHub

---

## **⚠️ Project Limitations**

This project is a **rule-based chatbot developed for educational and internship purposes**.

- The chatbot does not use advanced machine-learning algorithms.
- Responses are based on predefined rules and keywords.
- The chatbot cannot answer questions outside its predefined knowledge.
- The chatbot does not connect to external AI services or APIs.
- The chatbot does not use an external database.
- The chatbot does not require an internet connection.
- Conversation history is maintained only during the current application session.

---

## **🏁 Conclusion**

The **Artificial Intelligence Chatbot** successfully demonstrates the development of an interactive Java chatbot using **Java Swing, basic Natural Language Processing, rule-based Artificial Intelligence, and Object-Oriented Programming**.

The project provides real-time communication through a graphical interface, processes user input, identifies keywords and phrases, responds to frequently asked questions, handles general conversation, validates empty input, and provides appropriate responses for unknown questions.

The project fulfills the core requirements of a Java-based AI chatbot while maintaining a **simple, functional, and easy-to-understand implementation**.

---

## **👨‍💻 Author**

**Mubashir Hussain**

---

## **📄 License**

This project was developed for **educational and internship purposes** as part of the **CodeAlpha Java Development Internship**.
