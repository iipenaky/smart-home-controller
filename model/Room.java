import java.util.ArrayList;
import java.util.List;

/**
 * The Room class represents a room in the smart home.
 * Each room has a name and a list of devices that belong to it.
 */
public class Room {
    private final String name;
    private final List<Device> devices = new ArrayList<>();

    /**
     * Creates a new Room with the given name.
     *
     * @param name The name of the room.
     */
    public Room(String name) {
        this.name = name;
    }

    /**
     * Adds a device to this room.
     *
     * @param device The device to be added.
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Returns the list of devices in this room.
     *
     * @return A list of devices.
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Returns the name of the room.
     *
     * @return The room name.
     */
    public String getName() {
        return name;
    }

    /**
     * Turns ON all devices in the room.
     */
    public void turnAllOn() {
        devices.forEach(Device::turnOn);
    }

    /**
     * Turns OFF all devices in the room.
     */
    public void turnAllOff() {
        devices.forEach(Device::turnOff);
    }

    /**
     * Checks if all devices in the room are ON.
     *
     * @return true if all devices are ON, false otherwise.
     */
    public boolean areAllDevicesOn() {
        for (Device device : devices) {
            if (!device.isOn()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all devices in the room are OFF.
     *
     * @return true if all devices are OFF, false otherwise.
     */
    public boolean areAllDevicesOff() {
        for (Device device : devices) {
            if (device.isOn()) {
                return false;
            }
        }
        return true;
    }
}