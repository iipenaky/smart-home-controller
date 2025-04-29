import java.util.ArrayList;
import java.util.List;

/**
 * SmartHomeController manages all rooms and devices in the smart home system.
 * It is a singleton, meaning only one instance of this class exists.
 */
public class SmartHomeController {
    private static SmartHomeController instance;
    private final List<Room> rooms = new ArrayList<>();

    /**
     * Private constructor to prevent direct instantiation.
     * The singleton pattern is used to ensure only one instance of this controller.
     */
    private SmartHomeController() {}

    /**
     * Returns the single instance of the SmartHomeController.
     * If the instance does not exist, it is created.
     *
     * @return The instance of the SmartHomeController.
     */
    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    /**
     * Creates a new room and adds it to the smart home.
     *
     * @param name The name of the room.
     * @return The newly created room.
     */
    public Room createRoom(String name) {
        Room room = new Room(name);
        rooms.add(room);
        return room;
    }

    /**
     * Adds a device to a specific room.
     * It also registers the device with an observer to track actions performed on it.
     *
     * @param roomName The name of the room to add the device to.
     * @param device The device to be added to the room.
     * @param observer The observer that tracks actions on the device.
     * @return The added device.
     */
    public Device addDeviceToRoom(String roomName, Device device, DeviceObserver observer) {
        Room room = null;
        for (Room r : rooms) {
            if (r.getName().equals(roomName)) {
                room = r;
                break;
            }
        }
        if (room == null) {
            throw new RuntimeException("Room not found: " + roomName);
        }
        device.addObserver(observer);
        room.addDevice(device);
        return device;
    }
    

    /**
     * Returns a list of all rooms in the smart home.
     *
     * @return A list of rooms.
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Turns OFF all devices of a specific type (e.g., all doors).
     *
     * @param type The type of devices to turn off (e.g., "Door").
     */
    public void turnOffDevicesOfType(String type) {
        for (Room room : rooms) {
            for (Device device : room.getDevices()) {
                if (device.getClass().getSimpleName().equalsIgnoreCase(type)) {
                    device.turnOff();  
                }
            }
        }
    }
}