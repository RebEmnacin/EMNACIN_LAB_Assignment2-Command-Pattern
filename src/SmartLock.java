/**
 * Receiver class for a smart lock.
 *
 * This device was added AFTER the rest of the system was built, to prove
 * requirement #3: new devices can be added without touching HubController.java
 * or the Command interface at all. We only add this new receiver plus two
 * new Command classes (LockCommand, UnlockCommand).
 */
public class SmartLock {
    private boolean isLocked;

    public SmartLock() {
        this.isLocked = true;
    }

    public void lock() {
        isLocked = true;
        System.out.println("[SmartLock] is now LOCKED");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("[SmartLock] is now UNLOCKED");
    }
}
