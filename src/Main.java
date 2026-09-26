/**
 * Client class.
 * Creates the devices (receivers), wraps each action in a Command, registers
 * those commands with the HubController, then fires commands the same way
 * an app screen would when the user taps a button.
 */
public class Main 
{
    public static void main(String[] args) 
    {

        // 1. Create the actual devices
        Light livingRoomLight = new Light("Living Room");
        Thermostat thermostat = new Thermostat(70);
        MusicPlayer musicPlayer = new MusicPlayer();
        SmartLock frontDoorLock = new SmartLock(); // new device, added later

        // 2. Wrap each device action in a Command
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command tempUp = new ThermostatIncreaseCommand(thermostat);
        Command tempDown = new ThermostatDecreaseCommand(thermostat);
        Command playChill = new MusicPlayCommand(musicPlayer, "Chill Vibes");
        Command volumeDown = new MusicVolumeDownCommand(musicPlayer);
        Command lockDoor = new LockCommand(frontDoorLock);
        Command unlockDoor = new UnlockCommand(frontDoorLock);

        // 3. Register commands with the hub (this is all the hub ever sees)
        HubController hub = new HubController();
        hub.setCommand("living_room_light_on", lightOn);
        hub.setCommand("living_room_light_off", lightOff);
        hub.setCommand("thermostat_up", tempUp);
        hub.setCommand("thermostat_down", tempDown);
        hub.setCommand("music_play_chill", playChill);
        hub.setCommand("music_volume_down", volumeDown);
        hub.setCommand("front_door_lock", lockDoor);
        hub.setCommand("front_door_unlock", unlockDoor);

        // 4. Simulate a user pressing buttons on the app / hub
        System.out.println("--- Smart Home Automation Demo ---");
        hub.pressButton("living_room_light_on");
        hub.pressButton("thermostat_up");
        hub.pressButton("thermostat_up");
        hub.pressButton("music_play_chill");
        hub.pressButton("music_volume_down");
        hub.pressButton("front_door_lock");
        hub.pressButton("front_door_unlock");
        hub.pressButton("living_room_light_off");

        System.out.println("\n--- Trying an unregistered command ---");
        hub.pressButton("garage_door_open"); // not registered - handled gracefully
    }
}
