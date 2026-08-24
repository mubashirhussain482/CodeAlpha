package hotelreservation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class BookingFileManager {
    private static final String FILE_NAME = "src/hotelreservation/bookings.txt";
    public static void saveBooking(Reservation reservation) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            Customer customer = reservation.getCustomer();
            writer.println(
                    reservation.getBookingId() + "," +
                    customer.getName() + "," +
                    customer.getPhone() + "," +
                    customer.getEmail() + "," +
                    reservation.getRoomNumber() + "," +
                    reservation.getCategory() + "," +
                    reservation.getCheckIn() + "," +
                    reservation.getCheckOut() + "," +
                    reservation.getGuests() + "," +
                    reservation.getTotalAmount() + "," +
                    reservation.getStatus()
            );
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }
    public static ArrayList<Reservation> loadBookings() {
        ArrayList<Reservation> bookings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",", -1);
                Customer customer = new Customer(
                        data[1],
                        data[2],
                        data[3]
                );
                Reservation reservation = new Reservation(
                        data[0],
                        customer,
                        Integer.parseInt(data[4]),
                        data[5],
                        data[6],
                        data[7],
                        Integer.parseInt(data[8]),
                        Double.parseDouble(data[9]),
                        data[10]
                );
                bookings.add(reservation);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading bookings: " + e.getMessage());
        }
        return bookings;
    }
    public static boolean updateBookingStatus(String bookingId, String newStatus) {
        ArrayList<Reservation> bookings = loadBookings();
        boolean found = false;
        for (Reservation booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                booking.setStatus(newStatus);
                found = true;
                break;
            }
        }
        if (!found) {
            return false;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Reservation booking : bookings) {
                Customer customer = booking.getCustomer();
                writer.println(
                    booking.getBookingId() + "," +
                    customer.getName() + "," +
                    customer.getPhone() + "," +
                    customer.getEmail() + "," +
                    booking.getRoomNumber() + "," +
                    booking.getCategory() + "," +
                    booking.getCheckIn() + "," +
                    booking.getCheckOut() + "," +
                    booking.getGuests() + "," +
                    booking.getTotalAmount() + "," +
                    booking.getStatus()
                );
            }
        } catch (IOException e) {
            System.out.println("Error updating booking: " + e.getMessage());
            return false;
        }
        return true;
    }
}
