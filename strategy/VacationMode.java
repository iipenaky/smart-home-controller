/**
 * VacationMode class implements the AutomationMode interface.
 * In this mode, all devices are turned OFF except cameras and doors, which stay ON.
 */
public class VacationMode implements AutomationMode {

    /**
     * Executes the Vacation Mode settings on the SmartHomeController.
     * Cameras and doors will be turned ON, and all other devices will be turned OFF.
     *
     * @param controller The main smart home controller managing rooms and devices.
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
        System.out.println("[MODE] Vacation Mode Activated");
    }
}