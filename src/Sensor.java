public class Sensor implements Observer {
    @Override
    public void update(String roomName, String status) {
        if ("occupied".equals(status)) {
            System.out.println("Sensor: " + roomName + " is occupied");
        } else {
            System.out.println("Sensor: " + roomName + " is unoccupied");
        }
    }
}
