# **📈 TASK 2 – STOCK TRADING PLATFORM**

---

## **📌 Project Overview**

A console-based **Stock Trading Platform** developed in Java as part of the **CodeAlpha Java Programming Internship**.

The application simulates a basic stock trading environment where users can view market data, buy and sell stocks, manage their portfolio, track account balances, and monitor portfolio performance.

The project is developed using **Object-Oriented Programming (OOP)** principles to manage stocks, users, portfolios, holdings, and transactions.

---

## **🎯 Project Objectives**

The main objectives of this project are to:

- Simulate a basic stock trading environment
- Display available stock market data
- Allow users to buy and sell stocks
- Manage user cash balance and stock holdings
- Track portfolio value and performance
- Record buy and sell transactions
- Simulate changes in stock market prices
- Apply input validation to prevent invalid operations
- Demonstrate practical use of Object-Oriented Programming concepts

---

## **✨ Features**

### **📊 Market Data**

- Display available stocks
- Display company names and stock symbols
- Display current stock prices
- Display price changes
- Display percentage price changes
- Simulate stock price movements
- Refresh market prices with randomly generated changes

### **💰 Buy Stocks**

- Search for stocks using their symbols
- Display company name and current price
- Enter the desired quantity
- Calculate the total purchase cost
- Check available cash balance
- Prevent purchases when funds are insufficient
- Add purchased stocks to the user's portfolio
- Record successful buy transactions

### **📉 Sell Stocks**

- Search for stocks using their symbols
- Check whether the user owns the selected stock
- Display currently owned quantity
- Validate the selling quantity
- Prevent selling more shares than owned
- Calculate the total selling amount
- Add the received amount to the user's balance
- Remove sold shares from the portfolio
- Record successful sell transactions

### **📁 Portfolio Management**

- View currently owned stocks
- Display stock quantities
- Display average buying prices
- Display current market prices
- Calculate current stock values
- Calculate profit/loss for individual holdings
- Calculate total portfolio value
- Handle empty portfolios

### **📈 Portfolio Performance**

- Track initial account balance
- Display current cash balance
- Calculate total stock value
- Calculate total portfolio value
- Calculate total profit/loss
- Calculate percentage return on investment
- Update performance based on simulated market price changes

### **🧾 Transaction History**

- Record successful buy transactions
- Record successful sell transactions
- Generate unique transaction IDs
- Store transaction type
- Store stock information
- Store quantity and transaction price
- Calculate transaction amounts
- Display transaction date and time
- Handle empty transaction history

### **🛡️ Input Validation**

- Validate main menu input
- Handle non-numeric menu input
- Validate stock quantities
- Prevent zero or negative quantities
- Handle non-numeric quantity input
- Prevent purchases exceeding available balance
- Prevent selling more shares than owned
- Validate stock symbols
- Prevent invalid market prices
- Handle empty portfolio and transaction history

---

## **🧑‍💻 Object-Oriented Programming**

The project uses OOP concepts to organize and manage the trading system.

### **📦 Classes Used**

- **Stock** – Represents individual stocks and manages their prices and price changes.
- **StockMarket** – Manages available stocks and simulated market price updates.
- **User** – Stores user information, cash balance, initial balance, and portfolio.
- **Portfolio** – Manages the user's stock holdings and portfolio calculations.
- **Holding** – Represents a stock holding, including quantity and average buying price.
- **Transaction** – Represents buy and sell transactions.
- **StockTradingPlatform** – Controls the application flow, menu, trading operations, and user interaction.

### **🔹 OOP Concepts Applied**

- Encapsulation
- Classes and Objects
- Constructors
- Methods
- Object Composition
- Data hiding using private fields
- Getters and setters
- Modular program design

---

## **🖥️ Application Menu**

The application provides the following options:

```text
========================================
              MAIN MENU
========================================
1. View Market Data
2. Refresh Market Prices
3. Buy Stock
4. Sell Stock
5. View Portfolio
6. Portfolio Performance
7. Transaction History
8. Account Balance
9. Exit
========================================
```

---

## **📊 Simulated Market**

The application does not connect to a real stock exchange.

Instead, stock prices are simulated within the program. When the user selects **Refresh Market Prices**, each stock can randomly increase or decrease within a defined percentage range.

This allows users to experience changing market conditions and observe how those changes affect their portfolio.

---

## **💾 Data Storage**

This project intentionally does **not** use a database or File I/O.

All users, stocks, holdings, and transactions are stored **in memory using Java objects and collections** during program execution.

Therefore:

- No external database is required
- No external files are required
- No internet connection is required
- Data is reset when the application is closed

---

## **🛠️ Technologies Used**

- **Java**
- **Object-Oriented Programming (OOP)**
- **Java Collections**
- **ArrayList**
- **Scanner**
- **Random**
- **Console-Based User Interface**
- **Input Validation**
- **Git & GitHub**

---

## **▶️ How to Run**

### **1. Clone or download the repository**

Open the project in a Java-supported IDE such as **NetBeans, IntelliJ IDEA, or Eclipse**.

### **2. Open the project**

Make sure all Java classes are located in the appropriate package.

### **3. Run the main class**

Run:

```text
StockTradingPlatform.java
```

The application will start from the console and display the main menu.

### **4. Interact with the application**

Select the desired menu option by entering its corresponding number.

---

## **🧪 Validation Examples**

The application handles invalid inputs such as:

```text
Enter quantity: -5
Quantity must be greater than zero. Please try again.
```

```text
Enter quantity: abc
Invalid input. Please enter a whole number.
```

```text
Enter quantity: 100
Insufficient funds. Your balance is Rs. 60000.00.
Please enter a smaller quantity.
```

```text
Enter quantity: 10
You do not own enough shares. Please try again.
```

Invalid menu input is also handled:

```text
Enter your choice: abc
Invalid input. Please enter a number from 1 to 9.
```

---

## **📂 Project Structure**

```text
Stock Trading Platform
│
├── StockTradingPlatform.java
├── Stock.java
├── StockMarket.java
├── User.java
├── Portfolio.java
├── Holding.java
└── Transaction.java
```

---

## **🎓 Learning Outcomes**

Through this project, practical experience was gained in:

- Developing console-based Java applications
- Applying Object-Oriented Programming principles
- Designing classes and relationships between objects
- Managing stocks and user portfolios
- Implementing buying and selling operations
- Managing financial calculations
- Implementing transaction tracking
- Simulating changing market conditions
- Implementing robust input validation
- Using Java collections for in-memory data management
- Organizing and managing projects using Git and GitHub

---

## **⚠️ Project Limitations**

This project is a **simulation for educational and internship purposes**.

- Stock prices are simulated and are not real-time market prices.
- No real financial transactions are performed.
- Data is stored only during program execution.
- Portfolio and transaction data are lost when the application is closed.
- The application does not connect to an external stock market API.

---

## **🏁 Conclusion**

The **Stock Trading Platform** successfully demonstrates the core functionality of a basic stock trading environment using Java.

The project implements market data management, simulated price changes, buying and selling operations, portfolio management, performance calculation, transaction tracking, and input validation while following **Object-Oriented Programming principles**.

---

## **👨‍💻 Author**

**Mubashir Hussain**

---

## **📄 License**

This project was developed for **educational and internship purposes** as part of the **CodeAlpha Java Development Internship**.
