/**
 * Speaker class represents a speaker device in the smart home system.
 * It extends the Device class and provides specific functionality to turn the speaker ON or OFF,
 * with the specific behavior of playing or stopping music when turned ON or OFF.
 */
public class Speaker extends Device {

    /**
     * Creates a new Speaker with the given name.
     *
     * @param name The name of the speaker.
     */
    public Speaker(String name) {
        super(name);
    }

    /**
     * Turns the speaker ON, which starts playing music.
     * This overrides the turnOn method from the Device class to add specific behavior for speakers.
     */
    @Override
    public void turnOn() {
        super.turnOn(); 
        System.out.println(getName() + " speaker is playing music.");
    }

    /**
     * Turns the speaker OFF, which stops the music.
     * This overrides the turnOff method from the Device class to add specific behavior for speakers.
     */
    @Override
    public void turnOff() {
        super.turnOff(); 
        System.out.println(getName() + " speaker stopped playing music.");
    }
}