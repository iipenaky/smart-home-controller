import java.util.ArrayList;
import java.util.List;

/**
 * Device is an abstract class that represents a device in the smart home system.
 * It provides basic functionality to turn the device ON or OFF and notify observers about the actions.
 */
public abstract class Device {
    protected String name;
    protected boolean isOn;
    private final List<DeviceObserver> observers = new ArrayList<>();

    /**
     * Creates a new device with the specified name.
     *
     * @param name The name of the device.
     */
    public Device(String name) {
        this.name = name;
    }

    /**
     * Turns the device ON and notifies the observers about the action.
     * It only turns the device ON if it's currently OFF.
     */
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            notifyObservers("turned ON"); 
        }
    }

    /**
     * Turns the device OFF and notifies the observers about the action.
     * It only turns the device OFF if it's currently ON.
     */
    public void turnOff() {
        if (isOn) {
            isOn = false;
            notifyObservers("turned OFF"); 
        }
    }

    /**
     * Checks if the device is ON.
     *
     * @return true if the device is ON, false if it's OFF.
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Returns the name of the device.
     *
     * @return The name of the device.
     */
    public String getName() {
        return name;
    }

    /**
     * Removes a device observer from the list.
     *
     * @param observer The observer to be removed.
     */
    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    /**
     * Adds a device observer to the list.
     *
     * @param observer The observer to be added.
     */
    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered observers about a specific action performed on the device.
     *
     * @param action The action performed (e.g., "turned ON", "turned OFF").
     */
    protected void notifyObservers(String action) {
        for (DeviceObserver ob : observers) {
            ob.update(this, action);
        }
    }
}