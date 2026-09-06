# Smart Home Automation System

## Problem Statement

Imagine you're building a smart home automation system where various devices (lights, thermostat, music player, etc.) can be controlled remotely using a central hub or app. Each device has different functionalities, but you want to create a unified and flexible control mechanism.

Design a system that allows you to control multiple smart home devices with ease. Your goal is to create a solution where:

1. You can control a variety of devices from a central hub or app, sending commands like "Turn On," "Turn Off," "Increase Temperature," "Decrease Volume," etc.
2. Each device has unique actions associated with these commands. For example, turning on the lights might involve changing their brightness level, while turning on the music player may involve playing a specific playlist.
3. New devices can be seamlessly integrated into the system without modifying existing code. You want to ensure that adding a new device doesn't require changes to the central control logic.
4. Devices can be controlled without the central hub or app needing to understand the internal workings of each device. It should send high-level commands without needing low-level details.

Your challenge is to apply a design pattern that provides a flexible and scalable way to control a variety of smart home devices, ensuring that new devices can be added without disrupting the existing system's functionality.

## Design Pattern Used: Command Pattern

The **Command Pattern** is used to satisfy all four requirements:

- **Requirement 1 (unified control):** A single `Command` interface with one method, `execute()`, lets the `HubController` trigger any device action the exact same way, no matter what the device actually is.
- **Requirement 2 (unique actions per device):** Each concrete command class (e.g. `LightOnCommand`, `MusicPlayCommand`) wraps a specific *receiver* (the real device object) and calls whatever method makes sense for that device inside `execute()`.
- **Requirement 3 (add devices without touching existing code):** Adding `SmartLock` only required a new receiver class and two new command classes (`LockCommand`, `UnlockCommand`). `HubController.java`, `Command.java`, and every other existing class were left untouched. This is the Open/Closed Principle in action.
- **Requirement 4 (hub doesn't need internal details):** `HubController` only stores and calls `Command` objects through `execute()`. It never imports or references `Light`, `Thermostat`, `MusicPlayer`, or `SmartLock` directly.

## Project Structure

```
smart-home/
├── README.md
├── diagrams/
│   └── uml-class-diagram.pdf
└── src/
    ├── Command.java                    (interface)
    ├── Light.java                      (receiver)
    ├── Thermostat.java                 (receiver)
    ├── MusicPlayer.java                (receiver)
    ├── SmartLock.java                  (receiver - added later, proves extensibility)
    ├── LightOnCommand.java             (concrete command)
    ├── LightOffCommand.java            (concrete command)
    ├── ThermostatIncreaseCommand.java  (concrete command)
    ├── ThermostatDecreaseCommand.java  (concrete command)
    ├── MusicPlayCommand.java           (concrete command)
    ├── MusicVolumeDownCommand.java     (concrete command)
    ├── LockCommand.java                (concrete command - new device)
    ├── UnlockCommand.java              (concrete command - new device)
    ├── HubController.java              (invoker)
    └── Main.java                       (client)
```

## How to Run

```bash
cd src
javac *.java -d ../bin
cd ../bin
java Main
```

### Expected Output

```
--- Smart Home Automation Demo ---
[Light - Living Room] is ON (brightness: 100%)
[Thermostat] temperature increased to 71F
[Thermostat] temperature increased to 72F
[MusicPlayer] now playing playlist: "Chill Vibes" (volume: 50)
[MusicPlayer] volume down -> 40
[SmartLock] is now LOCKED
[SmartLock] is now UNLOCKED
[Light - Living Room] is OFF

--- Trying an unregistered command ---
[HubController] No command registered for: garage_door_open
```

## Extensibility Proof

`SmartLock` (and its `LockCommand` / `UnlockCommand`) was added as a fourth device type purely by:

1. Creating `SmartLock.java` (new receiver)
2. Creating `LockCommand.java` and `UnlockCommand.java` (new concrete commands)
3. Registering the new commands in `Main.java` with `hub.setCommand(...)`

**Zero lines were changed in `HubController.java` or `Command.java`.** That is the direct proof of requirement #3.
