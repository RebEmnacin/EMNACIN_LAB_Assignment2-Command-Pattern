/**
 * Receiver class for the thermostat device.
 */
public class Thermostat {
    private int temperature; // in Fahrenheit

    public Thermostat(int startingTemperature) {
        this.temperature = startingTemperature;
    }

    public void increaseTemperature() {
        temperature++;
        System.out.println("[Thermostat] temperature increased to " + temperature + "F");
    }

    public void decreaseTemperature() {
        temperature--;
        System.out.println("[Thermostat] temperature decreased to " + temperature + "F");
    }
}
