import java.util.List;
import java.util.Scanner;

/**
 * Main class for the Smart Home Controller application.
 * This class handles user interactions via the console.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SmartHomeController controller = SmartHomeController.getInstance();
    private static final ActionLogger logger = new ActionLogger();

    /**
     * Main method - Entry point of the application.
     * Displays a menu and responds to user input until the user exits.
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            // Reading user input
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createRoom();
                    break;
                case "2":
                    addDevice();
                    break;
                case "3":
                    controlDevice();
                    break;
                case "4":
                    controlRoomDevices();
                    break;
                case "5":
                    activateAutomationMode();
                    break;
                case "6":
                    listRoomsAndDevices();
                    break;
                case "7":
                    toggleDevicesByType();
                    break;
                case "0":
                    System.out.println("Exiting Smart Home Controller. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu options for the user.
     */
    private static void printMenu() {
        System.out.println("\nWelcome To Your Smart Home Controller");
        System.out.println("1. Create Room");
        System.out.println("2. Add Device to Room");
        System.out.println("3. Turn ON/OFF a Device");
        System.out.println("4. Turn ON/OFF All Devices in a Room");
        System.out.println("5. Activate Automation Mode (Night/Vacation/Party/Morning)");
        System.out.println("6. View Rooms and Devices");
        System.out.println("7. Turn ON/OFF Devices by Type");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Creates a new room based on user input.
     */
    private static void createRoom() {
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine().trim();
        if (roomName.isEmpty()) {
            System.out.println("Room name cannot be empty.");
            return;
        }
        controller.createRoom(roomName);
        System.out.println("Room '" + roomName + "' created successfully.");
    }

    /**
     * Adds a device to a room selected by the user.
     */
    private static void addDevice() {
        List<Room> rooms = controller.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available to add a device to. Please add a room.");
            return;
        }
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine().trim();
        boolean roomExists = false;

        for (Room r : rooms) {
            if (r.getName().equalsIgnoreCase(roomName)) {
                roomExists = true;
                break;
            }
        }

        if (!roomExists) {
            System.out.println(roomName + " not found.");
            return;
        }

        System.out.print("Enter device type (Light, Door, Thermostat, Camera, Speaker): ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (!type.equals("light") && !type.equals("door") && !type.equals("thermostat") && !type.equals("camera") && !type.equals("speaker")) {
            System.out.println("Invalid device type.");
            return;
        }

        System.out.print("Enter device name: ");
        String deviceName = scanner.nextLine().trim();

        try {
            Device newDevice = DeviceFactory.createDevice(type, deviceName);
            if (newDevice == null) {
                System.out.println("Unsupported device type.");
                return;
            }
            controller.addDeviceToRoom(roomName, newDevice, logger);
            System.out.println("Device '" + deviceName + "' added to '" + roomName + "'.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Allows the user to turn a specific device ON or OFF by name.
     */
    private static void controlDevice() {
        System.out.print("Enter device name to control: ");
        String deviceName = scanner.nextLine().trim();
        Device device = findDeviceByName(deviceName);

        if (device == null) {
            System.out.println("Device not found.");
            return;
        }

        System.out.print("Turn ON or OFF? (on/off): ");
        String action = scanner.nextLine().trim().toLowerCase();

        if (action.equals("on")) {
            device.turnOn();
        } else if (action.equals("off")) {
            device.turnOff();
        } else {
            System.out.println("Invalid action.");
        }
    }

    /**
     * Turns all devices in a selected room ON or OFF.
     */
    private static void controlRoomDevices() {
        List<Room> rooms = controller.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available to control. Please add a room.");
            return;
        }
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine().trim();
        Room targetRoom = null;

        for (Room room : controller.getRooms()) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                targetRoom = room;
                break;
            }
        }

        if (targetRoom == null) {
            System.out.println("Room not found.");
            return;
        }

        System.out.print("Turn all devices ON or OFF? (on/off): ");
        String action = scanner.nextLine().trim().toLowerCase();

        if (action.equals("on")) {
            targetRoom.turnAllOn();
        } else if (action.equals("off")) {
            targetRoom.turnAllOff();
        } else {
            System.out.println("Invalid action.");
        }
    }

    /**
     * Activates a predefined automation mode like night, vacation, etc.
     */
    private static void activateAutomationMode() {
        System.out.println("Available Modes: night, vacation, party, morning");
        System.out.print("Enter mode name: ");
        String modeName = scanner.nextLine().trim().toLowerCase();

        AutomationMode mode;

        if (modeName.equals("night")) {
            mode = new NightMode();
        } else if (modeName.equals("vacation")) {
            mode = new VacationMode();
        } else if (modeName.equals("party")) {
            mode = new PartyMode();
        } else if (modeName.equals("morning")) {
            mode = new MorningMode();
        } else {
            System.out.println("Invalid mode.");
            return;
        }

        mode.execute(controller);
    }

    /**
     * Lists all rooms and the devices inside each room with their current status.
     */
    private static void listRoomsAndDevices() {
        List<Room> rooms = controller.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Room room : rooms) {
            System.out.println("Room: " + room.getName());
            List<Device> devices = room.getDevices();
            if (devices.isEmpty()) {
                System.out.println("  No devices.");
            } else {
                for (Device device : devices) {
                    String deviceType = device.getClass().getSimpleName();
                    System.out.printf("  - %s: %s [%s]%n", deviceType, device.getName(), device.isOn() ? "ON" : "OFF");
                }
            }
        }
    }


    /**
     * Turns ON or OFF all devices of a specific type entered by the user.
     */
    private static void toggleDevicesByType() {
        System.out.print("Enter device type (Light, Door, Thermostat, Camera, Speaker): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Do you want to turn them ON or OFF? ");
        String action = scanner.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Room room : controller.getRooms()) {
            for (Device device : room.getDevices()) {
                if (device.getClass().getSimpleName().toLowerCase().equals(type)) {
                    if (action.equals("on")) {
                        device.turnOn();
                    } else if (action.equals("off")) {
                        device.turnOff();
                    } else {
                        System.out.println("Invalid action. Please enter 'on' or 'off'.");
                        return;
                    }
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No devices of type '" + type + "' found.");
        }
    }


    

    /**
     * Searches for a device by name in all rooms.
     *
     * @param name The name of the device to find.
     * @return The device object if found, otherwise null.
     */
    private static Device findDeviceByName(String name) {
        for (Room room : controller.getRooms()) {
            for (Device device : room.getDevices()) {
                if (device.getName().equalsIgnoreCase(name)) {
                    return device;
                }
            }
        }
        return null;
    }
}