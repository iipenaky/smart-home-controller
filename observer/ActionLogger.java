/**
 * ActionLogger class implements the DeviceObserver interface.
 * It logs actions performed on devices, such as turning them ON or OFF.
 */
public class ActionLogger implements DeviceObserver {

    /**
     * Called whenever a device performs an action (like ON or OFF).
     * This method prints a log message with the device name and action.
     *
     * @param device The device that performed the action.
     * @param action The action performed (e.g., "turned ON", "turned OFF").
     */
    @Override
    public void update(Device device, String action) {
        System.out.println("[LOG] " + device.getName() + " " + action);
    }
}