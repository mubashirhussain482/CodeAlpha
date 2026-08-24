package hotelreservation;
public class Payment {
    private String paymentId;
    private String bookingId;
    private String paymentMethod;
    private double amount;
    private String paymentStatus;
    public Payment(String paymentId, String bookingId, String paymentMethod,
                   double amount, String paymentStatus) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
    public String getPaymentId() {
        return paymentId;
    }
    public String getBookingId() {
        return bookingId;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public double getAmount() {
        return amount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
}
