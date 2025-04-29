/**
 * Camera class represents a camera device in the smart home system.
 * It extends the Device class and provides specific functionality to turn the camera ON or OFF.
 */
public class Camera extends Device {

    /**
     * Creates a new Camera with the given name.
     *
     * @param name The name of the camera.
     */
    public Camera(String name) {
        super(name);
    }

    /**
     * Turns the camera ON and starts recording.
     * This overrides the turnOn method from the Device class to add specific behavior for cameras.
     */
    @Override
    public void turnOn() {
        super.turnOn(); 
        System.out.println(getName() + " camera is now RECORDING.");
    }

    /**
     * Turns the camera OFF and stops recording.
     * This overrides the turnOff method from the Device class to add specific behavior for cameras.
     */
    @Override
    public void turnOff() {
        super.turnOff(); 
        System.out.println(getName() + " camera is now OFF.");
    }
}
