/**
 * Command interface.
 * Every action the hub can trigger (turn on a light, increase temperature, etc.)
 * is wrapped in a class that implements this interface.
 *
 * This is the key to the whole design: the HubController only ever talks to
 * this interface. It never needs to know whether it's dealing with a Light,
 * a Thermostat, or a device that doesn't exist yet.
 */
public interface Command {
    void execute();
}
