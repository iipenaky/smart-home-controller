/**
 * Thermostat class represents a thermostat device in the smart home system.
 * It extends the Device class and provides specific functionality to turn the thermostat ON or OFF,
 * with the specific behavior of heating when turned ON.
 */
public class Thermostat extends Device {

    /**
     * Creates a new Thermostat with the given name.
     *
     * @param name The name of the thermostat.
     */
    public Thermostat(String name) {
        super(name);
    }

    /**
     * Turns the thermostat ON, which in this case starts heating.
     * This overrides the turnOn method from the Device class to add specific behavior for thermostats.
     */
    @Override
    public void turnOn() {
        super.turnOn(); 
        System.out.println(getName() + " thermostat is now HEATING.");
    }

    /**
     * Turns the thermostat OFF.
     * This overrides the turnOff method from the Device class to add specific behavior for thermostats.
     */
    @Override
    public void turnOff() {
        super.turnOff(); 
        System.out.println(getName() + " thermostat is now OFF.");
    }
}