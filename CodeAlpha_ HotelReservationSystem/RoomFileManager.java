package hotelreservation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class RoomFileManager {
    private static final String FILE_NAME = "src/hotelreservation/rooms.txt";
    public static ArrayList<Room> loadRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int roomNumber = Integer.parseInt(data[0]);
                String category = data[1];
                double pricePerNight = Double.parseDouble(data[2]);
                int capacity = Integer.parseInt(data[3]);
                boolean available = Boolean.parseBoolean(data[4]);
                Room room = new Room(roomNumber,category,pricePerNight,capacity,available);
                rooms.add(room);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading room data: " + e.getMessage());
        }
        return rooms;
    }
}
