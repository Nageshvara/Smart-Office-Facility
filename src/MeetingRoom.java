import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    private String name;
    private int maxCapacity;
    private int minCapacity;
    private int currentOccupancy;
    private LocalDateTime lastOccupiedTime;
    private boolean isBooked;
    private LocalTime bookingEndTime;
    private int totalBookings = 0;
    private int totalBookingDuration = 0;
    private List<Observer> observers;

    public MeetingRoom(String name) {
        this.name = name;
        this.maxCapacity = 0;
        this.minCapacity = 2;
        this.currentOccupancy = 0;
        this.lastOccupiedTime = null;
        this.isBooked = false;
        this.bookingEndTime = null;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public String setMaxCapacity(int capacity) {
        if (capacity <= 0) {
            return "Invalid capacity. Please enter a valid positive number.";
        }
        this.maxCapacity = capacity;
        return name + " maximum capacity set to " + capacity + ".";
    }

    public String addOccupant(int numberOfPeople) {
        if (numberOfPeople < minCapacity && numberOfPeople != 0) {
            return name + " occupancy insufficient to mark as occupied.";
        }
        if (numberOfPeople < 0) {
            return "Invalid capacity. Please enter a valid positive number.";
        }
        if (numberOfPeople == 0) {
            currentOccupancy = 0;
            lastOccupiedTime = LocalDateTime.now(); // Update last occupied time when room becomes unoccupied
            setBookingStatus("unoccupied");
            return name + " is unoccupied now. AC and lights turned off.";
        }
        if (currentOccupancy + numberOfPeople > maxCapacity) {
            return "Occupancy exceeds room capacity.";
        }
        currentOccupancy += numberOfPeople;
        lastOccupiedTime = LocalDateTime.now(); // Update last occupied time
        setBookingStatus("occupied");
        return name + " is now occupied by " + currentOccupancy + " persons. AC and lights turned on.";
    }

    public String cancelBooking() {
        if (!isBooked) {
            return name + " is not booked. Cannot cancel booking.";
        }
        isBooked = false;
        bookingEndTime = null;
        currentOccupancy = 0;
        setBookingStatus("unoccupied");
        return "Booking for " + name + " cancelled successfully.";
    }

    public String book(String startTime, int duration, OfficeConfiguration officeConfig) {
        if (isBooked) {
            StringBuilder availableRooms = new StringBuilder(
                    name + " is already booked during this time. Available rooms: ");
            List<MeetingRoom> rooms = officeConfig.getRooms();
            for (MeetingRoom room : rooms) {
                if (!room.isBooked) {
                    availableRooms.append(room.getName()).append(", ");
                }
            }
            return availableRooms.toString();
        }

        LocalTime start;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            start = LocalTime.parse(startTime, formatter);
        } catch (DateTimeParseException e) {
            return "Invalid time format. Please use HH:mm format.";
        }

        bookingEndTime = start.plusMinutes(duration);
        isBooked = true;
        totalBookings++;
        totalBookingDuration += duration;
        return name + " booked from " + startTime + " for " + duration + " minutes.";
    }

    public String getRoomUsageStatistics() {
        return name + " Usage Statistics:\n" +
                "Total Bookings: " + totalBookings + "\n" +
                "Total Booking Duration: " + totalBookingDuration + " minutes\n" +
                "Current Occupancy: " + currentOccupancy + "\n";
    }

    public String checkStatusAndReleaseBooking() {
        if (lastOccupiedTime == null) {
            return name + " has never been occupied.";
        }

        LocalDateTime now = LocalDateTime.now();
        long minutesElapsed = java.time.Duration.between(lastOccupiedTime, now).toMinutes();
        if (!isBooked) {
            setBookingStatus("unoccupied");
            return name + " is now unoccupied. AC and lights turned off.";
        }
        if (currentOccupancy == 0 && minutesElapsed > 5) {
            // Release the booking if the room is unoccupied for more than 5 minutes
            if (isBooked) {
                isBooked = false;
                bookingEndTime = null;
                setBookingStatus("unoccupied");
                return name + " is now unoccupied. Booking released. AC and lights turned off.";
            }
            setBookingStatus("unoccupied");
            return name + " is now unoccupied. AC and lights turned off.";
        }
        return name + " status is being monitored.";
    }

    private void setBookingStatus(String status) {
        notifyObservers(status);
    }

    private void notifyObservers(String status) {
        for (Observer observer : observers) {
            observer.update(name, status);
        }
    }
}
