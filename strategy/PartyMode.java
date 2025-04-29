/**
 * PartyMode class implements the AutomationMode interface.
 * In this mode, only lights and speakers are turned ON to create a party atmosphere.
 */
public class PartyMode implements AutomationMode {

    /**
     * Executes the Party Mode settings on the SmartHomeController.
     * Turns ON all lights and speakers in every room.
     *
     * @param controller The smart home controller that manages all rooms and devices.
     */
    @Override
    public void execute(SmartHomeController controller) {
        for (Room room : controller.getRooms()) {
            for (Device device : room.getDevices()) {
                if (device instanceof Light || device instanceof Speaker) {
                    device.turnOn();
                }
            }
        }
        System.out.println("[MODE] Party Mode Activated");
    }    
}