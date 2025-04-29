/**
 * AutomationMode is an interface for different smart home automation modes.
 * Each mode (like Night, Vacation, Party, Morning) will define its own behavior
 * by implementing this interface.
 */
public interface AutomationMode {

    /**
     * Executes the automation mode using the SmartHomeController.
     * This method will define what happens in the smart home when the mode is activated.
     *
     * @param controller The smart home controller that manages all rooms and devices.
     */
    void execute(SmartHomeController controller);
}