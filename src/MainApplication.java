import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OfficeConfiguration officeConfig = new OfficeConfiguration();
        System.out.println("Smart Office Application Started.");

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] commandParts = input.split(" ");
            if (commandParts.length < 1) {
                System.out.println("Invalid command.");
                continue;
            }

            String commandType = commandParts[0];
            switch (commandType) {
                case "Config":
                    handleConfigCommand(commandParts, officeConfig);
                    break;
                case "Add":
                    handleAddOccupantCommand(commandParts, officeConfig);
                    break;
                case "Block":
                    handleBlockRoomCommand(commandParts, officeConfig);
                    break;
                case "Cancel":
                    handleCancelBookingCommand(commandParts, officeConfig);
                    break;
                case "Room":
                    handleRoomStatusCommand(commandParts, officeConfig);
                    break;
                case "Summary":
                    handleSummaryCommand(officeConfig);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void handleConfigCommand(String[] commandParts, OfficeConfiguration officeConfig) {
        if (commandParts.length < 3) {
            System.out.println("Invalid command.");
            return;
        }

        String subCommand = commandParts[1];
        try {
            switch (subCommand) {
                case "room":
                    if ("count".equals(commandParts[2])) {
                        int roomCount = Integer.parseInt(commandParts[3]);
                        System.out.println(officeConfig.configure(roomCount));
                    } else if ("max".equals(commandParts[2]) && "capacity".equals(commandParts[3])) {
                        int roomNumber = Integer.parseInt(commandParts[4]);
                        int capacity = Integer.parseInt(commandParts[5]);
                        MeetingRoom room = officeConfig.getRoom("Room " + roomNumber);
                        if (room != null) {
                            System.out.println(room.setMaxCapacity(capacity));
                        } else {
                            System.out.println("Room does not exist.");
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void handleAddOccupantCommand(String[] commandParts, OfficeConfiguration officeConfig) {
        if (commandParts.length < 4) {
            System.out.println("Invalid command.");
            return;
        }

        try {
            int roomNumber = Integer.parseInt(commandParts[2]);
            int numberOfPeople = Integer.parseInt(commandParts[3]);
            MeetingRoom room = officeConfig.getRoom("Room " + roomNumber);
            if (room != null) {
                System.out.println(room.addOccupant(numberOfPeople));
            } else {
                System.out.println("Room does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void handleBlockRoomCommand(String[] commandParts, OfficeConfiguration officeConfig) {
        if (commandParts.length < 5) {
            System.out.println("Invalid command.");
            return;
        }

        try {
            int roomNumber = Integer.parseInt(commandParts[2]);
            String startTime = commandParts[3];
            int duration = Integer.parseInt(commandParts[4]);
            MeetingRoom room = officeConfig.getRoom("Room " + roomNumber);
            if (room != null) {
                BookRoomCommand bookCommand = new BookRoomCommand(room, startTime, duration, officeConfig);
                System.out.println(bookCommand.execute());
            } else {
                System.out.println("Room does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void handleCancelBookingCommand(String[] commandParts, OfficeConfiguration officeConfig) {
        if (commandParts.length < 3) {
            System.out.println("Invalid command.");
            return;
        }

        try {
            int roomNumber = Integer.parseInt(commandParts[2]);
            MeetingRoom room = officeConfig.getRoom("Room " + roomNumber);
            if (room != null) {
                System.out.println(room.cancelBooking());
            } else {
                System.out.println("Room does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void handleRoomStatusCommand(String[] commandParts, OfficeConfiguration officeConfig) {
        if (commandParts.length < 3) {
            System.out.println("Invalid command.");
            return;
        }

        try {
            int roomNumber = Integer.parseInt(commandParts[2]);
            MeetingRoom room = officeConfig.getRoom("Room " + roomNumber);
            if (room != null) {
                System.out.println(room.checkStatusAndReleaseBooking());
            } else {
                System.out.println("Room does not exist.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private static void handleSummaryCommand(OfficeConfiguration officeConfig) {
        for (MeetingRoom room : officeConfig.getRooms()) {
            System.out.println(room.getRoomUsageStatistics());
        }
    }
}
