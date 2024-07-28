public class AirConditioning implements Observer {
    @Override
    public void update(String roomName, String status) {
        if ("occupied".equals(status)) {
            System.out.println("Air Conditioning: Turning on AC in " + roomName);
        } else {
            System.out.println("Air Conditioning: Turning off AC in " + roomName);
        }
    }
}
