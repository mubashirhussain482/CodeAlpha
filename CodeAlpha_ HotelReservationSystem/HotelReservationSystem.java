package hotelreservation;
import java.util.ArrayList;
import java.util.Scanner;
public class HotelReservationSystem {
    private static void searchAvailableRooms(ArrayList<Room> rooms, Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("       SEARCH AVAILABLE ROOMS");
        System.out.println("========================================");
        System.out.print("Enter room category (Standard/Deluxe/Suite): ");
        String category = scanner.nextLine().trim();
        System.out.print("Enter number of guests: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Enter number of guests: ");
        }
        int guests = scanner.nextInt();
        scanner.nextLine();
        if (guests <= 0) {
            System.out.println("Number of guests must be greater than 0.");
            return;
        }
        boolean found = false;
        System.out.println("\nAvailable Rooms");
        System.out.println("----------------------------------------");
        for (Room room : rooms) {
            if(room.isAvailable()&&room.getCategory().equalsIgnoreCase(category)&&room.getCapacity()>=guests){
                System.out.println("Room Number : " + room.getRoomNumber());
                System.out.println("Category    : " + room.getCategory());
                System.out.println("Price/Night : Rs. " + room.getPricePerNight());
                System.out.println("Capacity    : " + room.getCapacity() + " guests");
                System.out.println("----------------------------------------");
                found = true;
           }
        }
        if (!found) {
            System.out.println("No available rooms found.");
        }
    }
    private static void viewRoomDetails(ArrayList<Room> rooms) {
        System.out.println("\n========================================");
        System.out.println("           ROOM DETAILS");
        System.out.println("========================================");
        for (Room room : rooms) {
            System.out.println("Room Number    : " + room.getRoomNumber());
            System.out.println("Category       : " + room.getCategory());
            System.out.println("Price/Night    : Rs. " + room.getPricePerNight());
            System.out.println("Capacity       : " + room.getCapacity() + " guests");
            System.out.println("Availability   : " +
                (room.isAvailable() ? "Available" : "Not Available"));
            System.out.println("----------------------------------------");
        }
    }
    private static void makeReservation(ArrayList<Room> rooms, Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("          MAKE RESERVATION");
        System.out.println("========================================");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        if (phone.isEmpty()) {
            System.out.println("Phone number cannot be empty.");
            return;
        }
        if (!phone.matches("\\d+")) {
            System.out.println("Phone number must contain only digits.");
            return;
        }
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }
        System.out.print("Enter room number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid room number. Please enter a number.");
            scanner.next();
            System.out.print("Enter room number: ");
        }
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }
        if (selectedRoom == null) {
            System.out.println("Room not found.");
            return;
        }
        if (!selectedRoom.isAvailable()) {
            System.out.println("Room is currently not available.");
            return;
        }
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkIn = scanner.nextLine().trim();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOut = scanner.nextLine().trim();
        System.out.print("Enter number of guests: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Enter number of guests: ");
        }
        int guests = scanner.nextInt();
        scanner.nextLine();
        if (guests <= 0) {
            System.out.println("Number of guests must be greater than 0.");
            return;
        }
        if (guests > selectedRoom.getCapacity()) {
           System.out.println("This room can accommodate only "
                + selectedRoom.getCapacity() + " guests.");
            return;
        }
        long numberOfNights;
        try {
            java.time.LocalDate checkInDate = java.time.LocalDate.parse(checkIn);
            java.time.LocalDate checkOutDate = java.time.LocalDate.parse(checkOut);
            if (!checkOutDate.isAfter(checkInDate)) {
                System.out.println("Check-out date must be after check-in date.");
                return;
            }
            numberOfNights = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        }
        ArrayList<Reservation> bookings = BookingFileManager.loadBookings();
        for (Reservation booking : bookings) {
            if (booking.getRoomNumber() == roomNumber && !booking.getStatus().equalsIgnoreCase("Cancelled")) {
                java.time.LocalDate existingCheckIn = java.time.LocalDate.parse(booking.getCheckIn());
                java.time.LocalDate existingCheckOut = java.time.LocalDate.parse(booking.getCheckOut());
                java.time.LocalDate newCheckIn = java.time.LocalDate.parse(checkIn);
                java.time.LocalDate newCheckOut = java.time.LocalDate.parse(checkOut);
                boolean overlap = newCheckIn.isBefore(existingCheckOut) && newCheckOut.isAfter(existingCheckIn);
                if (overlap) {
                    System.out.println("Room is already booked for the selected dates.");
                    return;
                }
            }
        }
        double totalAmount = selectedRoom.getPricePerNight() * numberOfNights;
        String bookingId = "HB" + (1000 + bookings.size() + 1);
        Customer customer = new Customer(name, phone, email);
        Reservation reservation =
                new Reservation(
                    bookingId,
                    customer,
                    selectedRoom.getRoomNumber(),
                    selectedRoom.getCategory(),
                    checkIn,
                    checkOut,
                    guests,
                    totalAmount,
                    "Pending Payment"
                );
        BookingFileManager.saveBooking(reservation);
        System.out.println("\nReservation created successfully!");
        System.out.println("----------------------------------------");
        System.out.println("Booking ID      : " + bookingId);
        System.out.println("Room Number     : " + selectedRoom.getRoomNumber());
        System.out.println("Category        : " + selectedRoom.getCategory());
        System.out.println("Check-in        : " + checkIn);
        System.out.println("Check-out       : " + checkOut);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Guests          : " + guests);
        System.out.println("Total Amount    : Rs. " + totalAmount);
        System.out.println("Booking Status  : Pending Payment");
        System.out.println("----------------------------------------");
    }
    private static void makePayment(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("            MAKE PAYMENT");
        System.out.println("========================================");
        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine().trim();
        ArrayList<Reservation> bookings = BookingFileManager.loadBookings();
        Reservation selectedBooking = null;
        for (Reservation booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                selectedBooking = booking;
                break;
            }
        }
        if (selectedBooking == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (selectedBooking.getStatus().equalsIgnoreCase("Confirmed")) {
            System.out.println("Payment has already been completed.");
            return;
        }
        if (selectedBooking.getStatus().equalsIgnoreCase("Cancelled")) {
            System.out.println("This booking has been cancelled.");
            return;
        }
        System.out.println("\nBooking Details");
        System.out.println("----------------------------------------");
        System.out.println("Booking ID   : " + selectedBooking.getBookingId());
        System.out.println("Customer     : " + selectedBooking.getCustomer().getName());
        System.out.println("Room Number  : " + selectedBooking.getRoomNumber());
        System.out.println("Total Amount : Rs. " + selectedBooking.getTotalAmount());
        System.out.println("----------------------------------------");
        System.out.println("Payment Methods");
        System.out.println("1. Credit/Debit Card");
        System.out.println("2. Mobile Wallet");
        System.out.println("3. Cash");
        System.out.print("Select payment method: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Select payment method: ");
        }
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();
        String paymentMethod;
        switch (paymentChoice) {
            case 1:
                paymentMethod = "Credit/Debit Card";
                break;
            case 2:
                paymentMethod = "Mobile Wallet";
                break;
            case 3:
                paymentMethod = "Cash";
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }
        System.out.println("\nProcessing payment...");
        boolean updated = BookingFileManager.updateBookingStatus(bookingId, "Confirmed");
        if (updated) {
            System.out.println("Payment Successful!");
            System.out.println("----------------------------------------");
            System.out.println("Payment Method : " + paymentMethod);
            System.out.println("Amount Paid    : Rs. " + selectedBooking.getTotalAmount());
            System.out.println("Booking Status : Confirmed");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Payment could not be completed.");
        }
    }
    private static void viewBookingDetails(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("          BOOKING DETAILS");
        System.out.println("========================================");
        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine().trim();
        ArrayList<Reservation> bookings = BookingFileManager.loadBookings();
        Reservation selectedBooking = null;
        for (Reservation booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                selectedBooking = booking;
                break;
            }
        }
        if (selectedBooking == null) {
            System.out.println("Booking not found.");
            return;
        }
        Customer customer = selectedBooking.getCustomer();
        System.out.println("\n========================================");
        System.out.println("          RESERVATION DETAILS");
        System.out.println("========================================");
        System.out.println("Booking ID       : " + selectedBooking.getBookingId());
        System.out.println("Customer Name    : " + customer.getName());
        System.out.println("Phone Number     : " + customer.getPhone());
        System.out.println("Email            : " + customer.getEmail());
        System.out.println("Room Number      : " + selectedBooking.getRoomNumber());
        System.out.println("Room Category    : " + selectedBooking.getCategory());
        System.out.println("Check-in Date    : " + selectedBooking.getCheckIn());
        System.out.println("Check-out Date   : " + selectedBooking.getCheckOut());
        System.out.println("Number of Guests : " + selectedBooking.getGuests());
        System.out.println("Total Amount     : Rs. " + selectedBooking.getTotalAmount());
        System.out.println("Booking Status   : " + selectedBooking.getStatus());
        System.out.println("========================================");
    }
    private static void cancelReservation(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("         CANCEL RESERVATION");
        System.out.println("========================================");
        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine().trim();
        ArrayList<Reservation> bookings = BookingFileManager.loadBookings();
        Reservation selectedBooking = null;
        for (Reservation booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                selectedBooking = booking;
                break;
            }
        }
        if (selectedBooking == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (selectedBooking.getStatus().equalsIgnoreCase("Cancelled")) {
            System.out.println("This booking is already cancelled.");
            return;
        }
        System.out.println("\nBooking Details");
        System.out.println("----------------------------------------");
        System.out.println("Booking ID  : " + selectedBooking.getBookingId());
        System.out.println("Customer    : " + selectedBooking.getCustomer().getName());
        System.out.println("Room Number : " + selectedBooking.getRoomNumber());
        System.out.println("Check-in    : " + selectedBooking.getCheckIn());
        System.out.println("Check-out   : " + selectedBooking.getCheckOut());
        System.out.println("Status      : " + selectedBooking.getStatus());
        System.out.println("----------------------------------------");
        System.out.print("Are you sure you want to cancel this booking? (Y/N): ");
        String confirmation = scanner.nextLine().trim();
        if (!confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Cancellation cancelled.");
            return;
        }
       boolean updated = BookingFileManager.updateBookingStatus(bookingId, "Cancelled");
        if (updated) {
            System.out.println("Reservation cancelled successfully.");
            System.out.println("Room is now available for future bookings.");
        } else {
            System.out.println("Unable to cancel the reservation.");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> rooms = RoomFileManager.loadRooms();
        int choice;
        do {
            System.out.println("\n========================================");
            System.out.println("       HOTEL RESERVATION SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. View Room Details");
            System.out.println("3. Make Reservation");
            System.out.println("4. Make Payment");
            System.out.println("5. View Booking Details");
            System.out.println("6. Cancel Reservation");
            System.out.println("7. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    searchAvailableRooms(rooms, scanner);
                    break;
                case 2:
                    viewRoomDetails(rooms);
                    break;
                case 3:
                    makeReservation(rooms, scanner);
                    break;
                case 4:
                    makePayment(scanner);
                    break;
                case 5:
                    viewBookingDetails(scanner);
                    break;
                case 6:
                    cancelReservation(scanner);
                    break;
                case 7:
                    System.out.println("Thank you for using Hotel Reservation System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 7.");
            }
        } while (choice != 7);
        scanner.close();
    }
}
