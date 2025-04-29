/**
 * Light class represents a light device in the smart home system.
 * It extends the Device class and provides specific functionality to turn the light ON or OFF.
 */
public class Light extends Device {

    /**
     * Creates a new Light with the given name.
     *
     * @param name The name of the light.
     */
    public Light(String name) {
        super(name);
    }

    /**
     * Turns the light ON.
     * This overrides the turnOn method from the Device class to add specific behavior for lights.
     */
    @Override
    public void turnOn() {
        super.turnOn(); 
        System.out.println(getName() + " light is now ON.");
    }

    /**
     * Turns the light OFF.
     * This overrides the turnOff method from the Device class to add specific behavior for lights.
     */
    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(getName() + " light is now OFF.");
    }
}