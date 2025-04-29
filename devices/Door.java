/**
 * Door class represents a door device in the smart home system.
 * It extends the Device class and provides specific functionality to lock or unlock the door.
 */
public class Door extends Device {

    /**
     * Creates a new Door with the given name.
     *
     * @param name The name of the door.
     */
    public Door(String name) {
        super(name);
    }

    /**
     * Turns the door ON, which in this case locks the door.
     * This overrides the turnOn method from the Device class to add specific behavior for doors.
     */
    @Override
    public void turnOn() {
        super.turnOn(); 
        System.out.println(getName() + " door is now LOCKED.");
    }

    /**
     * Turns the door OFF, which in this case unlocks the door.
     * This overrides the turnOff method from the Device class to add specific behavior for doors.
     */
    @Override
    public void turnOff() {
        super.turnOff(); 
        System.out.println(getName() + " door is now UNLOCKED.");
    }
}
