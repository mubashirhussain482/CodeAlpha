package hotelreservation;
public class Room {
    private int roomNumber;
    private String category;
    private double pricePerNight;
    private int capacity;
    private boolean available;
    public Room(int roomNumber, String category, double pricePerNight, int capacity, boolean available) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.available = available;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getCategory() {
        return category;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public int getCapacity() {
        return capacity;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
