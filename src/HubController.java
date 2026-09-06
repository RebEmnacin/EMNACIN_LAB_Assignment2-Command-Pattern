import java.util.HashMap;
import java.util.Map;

/**
 * Invoker class.
 *
 * This is the "central hub / app" from the assignment. Notice it never
 * imports Light, Thermostat, MusicPlayer or SmartLock directly for its
 * control logic - it only stores and calls Command objects.
 *
 * That's what satisfies requirement #4 (hub doesn't need to know internal
 * workings of each device) and requirement #3 (new devices can be added
 * without modifying this class at all).
 */
public class HubController {
    private Map<String, Command> commandSlots = new HashMap<>();

    /**
     * Registers a command under a friendly name/slot,
     * e.g. "living_room_light_on".
     */
    public void setCommand(String slotName, Command command) {
        commandSlots.put(slotName, command);
    }

    /**
     * Fires a previously registered command.
     * This is the single generic entry point the "app" uses for every device.
     */
    public void pressButton(String slotName) {
        Command command = commandSlots.get(slotName);
        if (command == null) {
            System.out.println("[HubController] No command registered for: " + slotName);
            return;
        }
        command.execute();
    }
}
