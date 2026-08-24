package hotelreservation;
public class Reservation {
    private String bookingId;
    private Customer customer;
    private int roomNumber;
    private String category;
    private String checkIn;
    private String checkOut;
    private int guests;
    private double totalAmount;
    private String status;
    public Reservation(String bookingId, Customer customer, int roomNumber,
                       String category, String checkIn, String checkOut,
                       int guests, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.roomNumber = roomNumber;
        this.category = category;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    public String getBookingId() {
        return bookingId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getCategory() {
        return category;
    }
    public String getCheckIn() {
        return checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }
    public int getGuests() {
        return guests;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
