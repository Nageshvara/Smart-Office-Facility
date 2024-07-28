public class BookRoomCommand implements Command {
    private MeetingRoom room;
    private String startTime;
    private int duration;
    OfficeConfiguration officeConfig;

    public BookRoomCommand(MeetingRoom room, String startTime, int duration, OfficeConfiguration officeConfig) {
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
        this.officeConfig = officeConfig;
    }

    @Override
    public String execute() {
        if (room != null) {
            return room.book(startTime, duration, officeConfig);
        } else {
            return "Room does not exist.";
        }
    }
}
