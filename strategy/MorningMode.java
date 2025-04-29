/**
 * MorningMode class implements the AutomationMode interface.
 * In this mode, lights and thermostats are turned ON to prepare the house for the morning.
 */
public class MorningMode implements AutomationMode {

    /**
     * Executes the Morning Mode settings on the SmartHomeController.
     * Turns ON all lights and thermostats in every room.
     *
     * @param controller The smart home controller managing all rooms and devices.
     */
    @Override
    public void execute(SmartHomeController controller) {
        for (Room room : controller.getRooms()) {
            for (Device device : room.getDevices()) {
                if (device instanceof Light || device instanceof Thermostat) {
                    device.turnOn();
                }
            }
        }
        System.out.println("[MODE] Morning Mode Activated");
    }    
}