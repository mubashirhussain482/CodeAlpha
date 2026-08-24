package stocktradingplatform;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    private int transactionId;
    private String type;
    private Stock stock;
    private int quantity;
    private double price;
    private double totalAmount;
    private LocalDateTime dateTime;

    public Transaction(int transactionId, String type, Stock stock, int quantity, double price) {
        this.transactionId = transactionId;
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = quantity * price;
        this.dateTime = LocalDateTime.now();
    }
    public int getTransactionId() {
        return transactionId;
    }
    public String getType() {
        return type;
    }
    public Stock getStock() {
        return stock;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
}
