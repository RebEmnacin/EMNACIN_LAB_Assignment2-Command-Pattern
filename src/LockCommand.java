public class LockCommand implements Command {
    private SmartLock lock;

    public LockCommand(SmartLock lock) {
        this.lock = lock;
    }

    @Override
    public void execute() {
        lock.lock();
    }
}
