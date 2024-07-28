public class CancelBookingCommand implements Command {
    private MeetingRoom room;

    public CancelBookingCommand(MeetingRoom room) {
        this.room = room;
    }

    @Override
    public String execute() {
        if (room != null) {
            return room.cancelBooking();
        } else {
            return "Room does not exist.";
        }
    }
}
