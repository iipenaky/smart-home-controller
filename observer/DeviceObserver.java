/**
 * DeviceObserver is an interface used to observe changes or actions on devices.
 * Classes that implement this interface can respond to device updates,
 * like when a device is turned ON or OFF.
 */
public interface DeviceObserver {

    /**
     * This method is called when a device performs an action.
     *
     * @param device The device that was updated.
     * @param action A description of the action (e.g., "turned ON", "turned OFF").
     */
    void update(Device device, String action);
}