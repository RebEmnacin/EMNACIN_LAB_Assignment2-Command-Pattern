/**
 * Concrete Command.
 * Wraps a Light (the receiver) and knows exactly which method to call on it
 * when execute() is triggered.
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
