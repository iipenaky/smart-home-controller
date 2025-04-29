/**
 * DeviceFactory is responsible for creating instances of different types of devices.
 * Based on the device type provided, it returns the corresponding device object.
 */
public class DeviceFactory {

    /**
     * Creates a device instance based on the provided type and name.
     * The type determines which specific device is created (e.g., Light, Door, Thermostat, Camera, Speaker).
     *
     * @param type The type of the device (e.g., "light", "door", "thermostat", "camera", "speaker").
     * @param name The name of the device.
     * @return A Device object corresponding to the type, or null if the type is invalid.
     */
    public static Device createDevice(String type, String name) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(name);
            case "door":
                return new Door(name); 
            case "thermostat":
                return new Thermostat(name);
            case "camera":
                return new Camera(name); 
            case "speaker":
                return new Speaker(name); 
            default:
                return null; 
        }
    }
}