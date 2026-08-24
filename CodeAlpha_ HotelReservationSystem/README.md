# **🏨 HOTEL RESERVATION SYSTEM**

---

## **📌 Project Overview**

A console-based **Hotel Reservation System** developed in Java as part of the **CodeAlpha Java Programming Internship**.

The application allows users to search available hotel rooms, view room details, make reservations, simulate payments, view booking details, and cancel reservations.

The project is developed using **Object-Oriented Programming (OOP)** principles and **File I/O** for storing room information and booking records.

---

## **🎯 Project Objectives**

The main objectives of this project are to:

* Simulate a basic hotel reservation environment
* Search and display available hotel rooms
* Categorize rooms into Standard, Deluxe, and Suite
* Allow users to make hotel room reservations
* Calculate the total reservation cost
* Simulate the payment process
* Allow users to view booking details
* Allow users to cancel reservations
* Manage room availability based on reservation dates
* Prevent overlapping reservations
* Store room and booking information using File I/O
* Apply input validation to prevent invalid operations
* Demonstrate practical use of Object-Oriented Programming concepts

---

## **✨ Features**

### **🏨 Room Management**

* Display available hotel rooms
* Display room numbers
* Display room categories
* Display price per night
* Display maximum guest capacity
* Display room availability
* Support Standard, Deluxe, and Suite room categories

### **🔎 Search Available Rooms**

* Search rooms by category
* Enter the required number of guests
* Check room capacity
* Display only available rooms
* Prevent selection of rooms that cannot accommodate the required number of guests
* Handle cases where no suitable rooms are available

### **📅 Make Reservation**

* Enter customer name
* Enter phone number
* Enter email address
* Select a room using its room number
* Enter check-in date
* Enter check-out date
* Enter number of guests
* Validate room availability
* Validate guest capacity
* Validate check-in and check-out dates
* Calculate number of nights
* Calculate total reservation cost
* Generate a unique booking ID
* Store reservation details in a file
* Set new reservations to Pending Payment status

### **💳 Payment Simulation**

* Search for a booking using its Booking ID
* Display booking and payment amount
* Provide simple payment methods
* Support Credit/Debit Card
* Support Mobile Wallet
* Support Cash
* Simulate successful payment
* Change booking status from Pending Payment to Confirmed
* Prevent payment for already confirmed bookings
* Prevent payment for cancelled bookings

### **📋 Booking Details**

* Search bookings using Booking ID
* Display customer information
* Display room information
* Display check-in and check-out dates
* Display number of guests
* Display total amount
* Display current booking status
* Handle invalid or non-existing Booking IDs

### **❌ Cancel Reservation**

* Search reservation using Booking ID
* Display reservation details before cancellation
* Ask for cancellation confirmation
* Change booking status to Cancelled
* Prevent cancellation of an already cancelled booking
* Allow the room to be booked again after cancellation

### **📆 Room Availability**

* Check existing reservations for the selected room
* Compare reservation dates
* Prevent overlapping reservations
* Allow bookings when the previous guest has checked out
* Ignore cancelled reservations when checking availability
* Allow cancelled rooms to be reserved again

### **🛡️ Input Validation**

* Validate main menu input
* Handle non-numeric menu input
* Validate room numbers
* Validate room categories
* Validate number of guests
* Prevent zero or negative guest counts
* Validate customer name
* Validate phone number
* Prevent non-numeric phone numbers
* Validate email input
* Validate date format
* Prevent invalid dates
* Prevent check-out dates before or equal to check-in dates
* Prevent reservations exceeding room capacity
* Prevent reservations for overlapping dates
* Validate Booking IDs
* Prevent duplicate payments
* Prevent cancellation of already cancelled bookings

---

## **🧑‍💻 Object-Oriented Programming**

The project uses OOP concepts to organize and manage the hotel reservation system.

### **📦 Classes Used**

* **Room** – Represents a hotel room and stores its room number, category, price, capacity, and availability.
* **Customer** – Stores customer information including name, phone number, and email.
* **Reservation** – Represents a hotel booking and connects customer and room information with reservation dates, guests, total amount, and booking status.
* **Payment** – Represents simulated payment information including payment ID, booking ID, payment method, amount, and payment status.
* **RoomFileManager** – Handles reading room information from the rooms file.
* **BookingFileManager** – Handles saving, reading, and updating booking information in the bookings file.
* **HotelReservationSystem** – Controls the application flow, menu, room search, reservations, payments, booking details, and cancellations.

### **🔹 OOP Concepts Applied**

* Encapsulation
* Classes and Objects
* Constructors
* Methods
* Object Composition
* Data hiding using private fields
* Getters and setters
* Modular program design

---

## **🖥️ Application Menu**

The application provides the following options:

```text
========================================
       HOTEL RESERVATION SYSTEM
========================================
1. Search Available Rooms
2. View Room Details
3. Make Reservation
4. Make Payment
5. View Booking Details
6. Cancel Reservation
7. Exit
========================================
```

---

## **💾 Data Storage**

This project uses **File I/O** instead of a database to store room and booking information.

### **Room Data**

Room information is stored in:

```text
rooms.txt
```

The file contains information such as:

* Room number
* Room category
* Price per night
* Guest capacity
* Availability

### **Booking Data**

Reservation information is stored in:

```text
bookings.txt
```

The file stores:

* Booking ID
* Customer information
* Room information
* Check-in and check-out dates
* Number of guests
* Total amount
* Booking status

Booking records are updated when payments are completed or reservations are cancelled.

---

## **📅 Reservation Availability Logic**

The system checks existing booking dates before creating a new reservation.

For example, if a room is booked from:

```text
2026-09-01 → 2026-09-04
```

another reservation such as:

```text
2026-09-03 → 2026-09-09
```

will not be allowed because the dates overlap.

However:

```text
2026-09-04 → 2026-09-09
```

can be booked because the previous guest checks out on September 4.

Cancelled reservations do not block the room from being booked again.

---

## **🛠️ Technologies Used**

* **Java**
* **Object-Oriented Programming (OOP)**
* **File I/O**
* **ArrayList**
* **Scanner**
* **LocalDate**
* **DateTimeFormatter / Date-Time API**
* **Console-Based User Interface**
* **Input Validation**
* **Git & GitHub**

---

## **▶️ How to Run**

### **1. Clone or download the repository**

Open the project in a Java-supported IDE such as **NetBeans, IntelliJ IDEA, or Eclipse**.

### **2. Open the project**

Make sure the `hotelreservation` package contains all Java classes and text files.

### **3. Make sure the data files are present**

The following files are required:

```text
rooms.txt
bookings.txt
```

### **4. Run the main class**

Run:

```text
HotelReservationSystem.java
```

The application will start from the console and display the main menu.

### **5. Interact with the application**

Select the desired menu option by entering its corresponding number.

---

## **🧪 Validation Examples**

The application handles invalid inputs such as:

```text
Enter number of guests: abc
Invalid input. Please enter a number.
```

```text
Enter number of guests: 0
Number of guests must be greater than 0.
```

```text
Enter phone number: abc
Phone number must contain only digits.
```

```text
Enter check-in date: 2026-09-10
Enter check-out date: 2026-09-08
Check-out date must be after check-in date.
```

```text
Enter room number: 999
Room not found.
```

```text
Room is already booked for the selected dates.
```

```text
Enter Booking ID: HB9999
Booking not found.
```

```text
This booking is already cancelled.
```

Invalid menu input is also handled:

```text
Enter your choice: abc
Invalid input. Please enter a number.
```

---

## **📂 Project Structure**

```text
Hotel Reservation System
│
└── hotelreservation
    │
    ├── Room.java
    ├── Customer.java
    ├── Reservation.java
    ├── Payment.java
    ├── RoomFileManager.java
    ├── BookingFileManager.java
    ├── HotelReservationSystem.java
    ├── rooms.txt
    └── bookings.txt
```

---

## **🎓 Learning Outcomes**

Through this project, practical experience was gained in:

* Developing console-based Java applications
* Applying Object-Oriented Programming principles
* Designing classes and relationships between objects
* Implementing hotel room categorization
* Managing room availability
* Implementing room search functionality
* Creating and managing reservations
* Calculating reservation costs
* Implementing date-based availability checking
* Preventing overlapping reservations
* Simulating payment processing
* Managing booking cancellation
* Reading and writing data using File I/O
* Implementing robust input validation
* Using Java collections for data management
* Organizing and managing projects using Git and GitHub

---

## **⚠️ Project Limitations**

This project is a **simulation for educational and internship purposes**.

* Payment processing is simulated and does not involve real financial transactions.
* No real payment gateway is connected.
* Room information is stored using a text file instead of a database.
* Booking information is stored using File I/O.
* The application is console-based.
* The system does not connect to a real hotel management service.
* No real-time hotel availability service is used.

---

## **🏁 Conclusion**

The **Hotel Reservation System** successfully demonstrates the core functionality of a basic hotel booking environment using Java.

The project implements room categorization, room searching, reservation management, date-based room availability, simulated payments, booking details, reservation cancellation, File I/O, and input validation while following **Object-Oriented Programming principles**.

---

## **👨‍💻 Author**

**Mubashir Hussain**

---

## **📄 License**

This project was developed for **educational and internship purposes** as part of the **CodeAlpha Java Development Internship**.
