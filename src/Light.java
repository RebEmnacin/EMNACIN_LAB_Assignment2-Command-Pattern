/**
 * Receiver class.
 * Contains the actual device logic. Knows nothing about "commands" -
 * it just exposes normal methods a Light would have.
 */
public class Light {
    private String location;
    private boolean isOn;
    private int brightness; // 0-100

    public Light(String location) {
        this.location = location;
        this.isOn = false;
        this.brightness = 0;
    }

    public void turnOn() {
        isOn = true;
        brightness = 100;
        System.out.println("[Light - " + location + "] is ON (brightness: " + brightness + "%)");
    }

    public void turnOff() {
        isOn = false;
        brightness = 0;
        System.out.println("[Light - " + location + "] is OFF");
    }

    public void setBrightness(int level) {
        this.brightness = level;
        System.out.println("[Light - " + location + "] brightness set to " + level + "%");
    }
}
