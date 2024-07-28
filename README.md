# Smart-Office-Facility

Yes, the `MainApplication` can be considered to use a singleton pattern for the `OfficeConfiguration` instance by initializing it only once and using the same instance throughout the application. Here’s the updated explanation reflecting that:

### MainApplication.java

**Purpose**: The `MainApplication` class serves as the entry point for the smart office application, providing a command-line interface for configuring the office, managing meeting room bookings, and retrieving room status and usage statistics.

#### Functions:
- **`main(String[] args)`**: The main method initializes the `OfficeConfiguration` and continuously listens for user commands via the command line. It parses and handles different commands to configure rooms, add occupants, book or cancel room bookings, and display room status and usage statistics.
- **`handleConfigCommand(String[] commandParts, OfficeConfiguration officeConfig)`**: Handles the "Config" command for configuring room count and setting room capacities.
- **`handleAddOccupantCommand(String[] commandParts, OfficeConfiguration officeConfig)`**: Handles the "Add" command for adding occupants to a specific room.
- **`handleBlockRoomCommand(String[] commandParts, OfficeConfiguration officeConfig)`**: Handles the "Block" command for booking a room at a specified start time and duration.
- **`handleCancelBookingCommand(String[] commandParts, OfficeConfiguration officeConfig)**`: Handles the "Cancel" command for canceling the booking of a specific room.
- **`handleRoomStatusCommand(String[] commandParts, OfficeConfiguration officeConfig)`**: Handles the "Room" command for checking the status of a specific room and releasing its booking if necessary.
- **`handleSummaryCommand(OfficeConfiguration officeConfig)`**: Handles the "Summary" command to display usage statistics for all configured meeting rooms.

**Design Patterns**:
- **Command Pattern**: The `MainApplication` uses the Command pattern to handle various user commands, encapsulating requests as objects (`BookRoomCommand`, `CancelBookingCommand`, etc.) to provide flexibility in executing, delaying, or queueing requests.
- **Singleton Pattern**: The `MainApplication` uses a singleton pattern for the `OfficeConfiguration` instance by initializing it only once and using the same instance throughout the application, ensuring that there is a single point of configuration and management for the office.

### Command.java

**Purpose**: The `Command` interface represents the Command design pattern, which encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

#### Functions:
- **`execute()`**: This method is meant to be overridden by concrete command classes. When called, it will execute the specific command it encapsulates, returning a `String` that indicates the outcome of the command.

**Design Pattern**: **Command Pattern**. This pattern allows for the encapsulation of a request as an object, providing flexibility in executing, delaying, or queueing requests.

### Observer.java

**Purpose**: The `Observer` interface represents the Observer design pattern, which defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

#### Functions:
- **`update(String roomName, String status)`**: This method is meant to be overridden by concrete observer classes. It is called when the subject changes its state, providing the room name and its status.

**Design Pattern**: **Observer Pattern**. This pattern is used to create a subscription mechanism to allow multiple objects to listen to and react to events or changes in another object.

### Light.java

**Purpose**: The `Light` class implements the `Observer` interface and represents a concrete observer in the Observer design pattern.

#### Functions:
- **`update(String roomName, String status)`**: This method is called when the room status changes. If the status is "occupied," it prints a message indicating that the lights in the specified room are turned on. Otherwise, it indicates that the lights in the specified room are turned off.

**Design Pattern**: **Observer Pattern**. `Light` acts as a concrete observer, updating its state in response to changes in the `MeetingRoom` it is observing.

### Sensor.java

**Purpose**: The `Sensor` class implements the `Observer` interface and represents another concrete observer in the Observer design pattern.

#### Functions:
- **`update(String roomName, String status)`**: This method is called when the room status changes. If the status is "occupied," it prints a message indicating that the specified room is occupied. Otherwise, it indicates that the specified room is unoccupied.

**Design Pattern**: **Observer Pattern**. `Sensor` acts as a concrete observer, updating its state in response to changes in the `MeetingRoom` it is observing.

### SetMaxCapacityCommand.java

**Purpose**: The `SetMaxCapacityCommand` class implements the `Command` interface and represents a concrete command in the Command design pattern.

#### Functions:
- **Constructor `SetMaxCapacityCommand(MeetingRoom room, int capacity)`**: Initializes the command with a specific `MeetingRoom` and the capacity to be set.
- **`execute()`**: This method sets the maximum capacity of the specified `MeetingRoom` if the room exists. It returns a message indicating the result of the operation.

**Design Pattern**: **Command Pattern**. `SetMaxCapacityCommand` encapsulates the request to set the maximum capacity of a meeting room as an object, providing a method to execute this request.

### AddOccupantCommand.java

**Purpose**: The `AddOccupantCommand` class implements the `Command` interface and represents a concrete command in the Command design pattern.

#### Functions:
- **Constructor `AddOccupantCommand(MeetingRoom room, int occupants)`**: Initializes the command with a specific `MeetingRoom` and the number of occupants to be added.
- **`execute()`**: This method adds the specified number of occupants to the `MeetingRoom` if the room exists. It returns a message indicating the result of the operation.

**Design Pattern**: **Command Pattern**. `AddOccupantCommand` encapsulates the request to add occupants to a meeting room as an object, providing a method to execute this request.

### AirConditioning.java

**Purpose**: The `AirConditioning` class implements the `Observer` interface and represents a concrete observer in the Observer design pattern.

#### Functions:
- **`update(String roomName, String status)`**: This method is called when the room status changes. If the status is "occupied," it prints a message indicating that the air conditioning in the specified room is turned on. Otherwise, it indicates that the air conditioning in the specified room is turned off.

**Design Pattern**: **Observer Pattern**. `AirConditioning` acts as a concrete observer, updating its state in response to changes in the `MeetingRoom` it is observing.

### BookRoomCommand.java

**Purpose**: The `BookRoomCommand` class implements the `Command` interface and represents a concrete command in the Command design pattern.

#### Functions:
- **Constructor `BookRoomCommand(MeetingRoom room, String startTime, int duration, OfficeConfiguration officeConfig)`**: Initializes the command with a specific `MeetingRoom`, start time, duration, and office configuration.
- **`execute()`**: This method books the `MeetingRoom` if it is not already booked, starting at the specified time for the specified duration. It returns a message indicating the result of the booking operation.

**Design Pattern**: **Command Pattern**. `BookRoomCommand` encapsulates the request to book a meeting room as an object, providing a method to execute this request.

### CancelBookingCommand.java

**Purpose**: The `CancelBookingCommand` class implements the `Command` interface and represents a concrete command in the Command design pattern.

#### Functions:
- **Constructor `CancelBookingCommand(MeetingRoom room)`**: Initializes the command with a specific `MeetingRoom`.
- **`execute()`**: This method cancels the booking for the `MeetingRoom` if it exists and is currently booked. It returns a message indicating the result of the cancellation operation.

**Design Pattern**: **Command Pattern**. `CancelBookingCommand` encapsulates the request to cancel a meeting room booking as an object, providing a method to execute this request.

### MeetingRoom.java

**Purpose**: The `MeetingRoom` class represents a meeting room within the smart office, managing its booking status, occupancy, and notifying observers of any changes in its status.

#### Functions:
- **Constructor `MeetingRoom(String name)`**: Initializes the meeting room with the specified name, setting default values for capacity, occupancy, booking status, and creating an empty list of observers.
- **`getName()`**: Returns the name of the meeting room.
- **`addObserver(Observer observer)`**: Adds an observer to the list of observers for this meeting room.
- **`setMaxCapacity(int capacity)`**: Sets the maximum capacity for the room and returns a message indicating the result.
- **`addOccupant(int numberOfPeople)`**: Adds the specified number of occupants to the room, updates the last occupied time, and notifies observers of the status change. Returns a message indicating the result.
- **`cancelBooking()`**: Cancels the current booking if the room is booked, resets occupancy, and notifies observers of the status change. Returns a message indicating the result.
- **`book(String startTime, int duration, OfficeConfiguration officeConfig)`**: Books the room for the specified start time and duration if it is not already booked, returning a message indicating the result.
- **`getRoomUsageStatistics()`**: Returns statistics about the room's usage, including total bookings, total booking duration, and current occupancy.
- **`checkStatusAndReleaseBooking()`**: Checks the room's status and releases the booking if the room has been unoccupied for more than 5 minutes. Notifies observers of the status change and returns a message indicating the result.
- **`setBookingStatus(String status)`**: Sets the booking status and notifies observers.
- **`notifyObservers(String status)`**: Notifies all observers of the room's status change.

**Design Pattern**: **Observer Pattern**. `MeetingRoom` acts as the subject that notifies its observers (`Sensor`, `Light`, `AirConditioning`) of any changes in its status.

### OfficeConfiguration.java

**Purpose**: The `OfficeConfiguration` class manages the configuration of the office, including the setup and retrieval of meeting rooms.

#### Functions:
- **Constructor `OfficeConfiguration()`**: Initializes an empty list of meeting rooms.
- **`configure(int roomCount)`**: Configures the office with the specified number of meeting rooms, adding observers (`Sensor`, `Light`, `AirConditioning`) to each room. Returns a message indicating the result.
- **`getRoom(String name)`**: Retrieves a meeting room by its name. Returns the meeting room if found, otherwise returns null.
- **`getRooms()`**: Returns the list of all meeting rooms in the office.

**Design Pattern**: **Observer Pattern**. `OfficeConfiguration` sets up the `MeetingRoom` instances with observers to monitor and react to changes in the rooms' status.

---
