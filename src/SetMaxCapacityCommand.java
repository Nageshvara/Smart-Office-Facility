public class SetMaxCapacityCommand implements Command {
    private MeetingRoom room;
    private int capacity;

    public SetMaxCapacityCommand(MeetingRoom room, int capacity) {
        this.room = room;
        this.capacity = capacity;
    }

    @Override
    public String execute() {
        if (room != null) {
            return room.setMaxCapacity(capacity);
        } else {
            return "Room does not exist.";
        }
    }
}
