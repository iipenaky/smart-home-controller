/**
 * NightMode class implements the AutomationMode interface.
 * In this mode:
 * - All devices are turned OFF initially.
 * - Then, Cameras and Doors are turned ON for night security.
 */
public class NightMode implements AutomationMode {

    /**
     * Executes the Night Mode settings on the SmartHomeController.
     * - Turns OFF all devices in all rooms.
     * - Turns ON all camera and door devices for security.
     *
     * @param controller The smart home controller managing rooms and devices.
     */
    @Override
    public void execute(SmartHomeController controller) {
        controller.getRooms().forEach(room -> {
            room.getDevices().forEach(device -> {
                if ((device instanceof Camera) || (device instanceof Door)) {
                    device.turnOn();  
                } else {
                    device.turnOff();
                }
            });
        });
        System.out.println("[MODE] Night Mode Activated");
    }
}
