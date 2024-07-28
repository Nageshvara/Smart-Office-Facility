import java.util.ArrayList;
import java.util.List;

public class OfficeConfiguration {
    private List<MeetingRoom> rooms;

    OfficeConfiguration() {
        rooms = new ArrayList<>();
    }

    public String configure(int roomCount) {
        rooms.clear();
        for (int i = 1; i <= roomCount; i++) {
            MeetingRoom room = new MeetingRoom("Room " + i);
            Sensor sensor = new Sensor();
            Light light = new Light();
            AirConditioning ac = new AirConditioning();
            room.addObserver(sensor);
            room.addObserver(light);
            room.addObserver(ac);
            rooms.add(room);
        }
        return "Office configured with " + roomCount + " meeting rooms.";
    }

    public MeetingRoom getRoom(String name) {
        for (MeetingRoom room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    public List<MeetingRoom> getRooms() {
        return rooms;
    }
}
