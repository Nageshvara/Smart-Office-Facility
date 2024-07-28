public class Light implements Observer {
    @Override
    public void update(String roomName, String status) {
        if ("occupied".equals(status)) {
            System.out.println("Light: Turning on lights in " + roomName);
        } else {
            System.out.println("Light: Turning off lights in " + roomName);
        }
    }
}
