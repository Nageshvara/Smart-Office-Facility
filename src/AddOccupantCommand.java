public class AddOccupantCommand implements Command {
    private MeetingRoom room;
    private int occupants;

    public AddOccupantCommand(MeetingRoom room, int occupants) {
        this.room = room;
        this.occupants = occupants;
    }

    @Override
    public String execute() {
        if (room != null) {
            return room.addOccupant(occupants);
        } else {
            return "Room does not exist.";
        }
    }
}
