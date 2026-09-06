public class UnlockCommand implements Command {
    private SmartLock lock;

    public UnlockCommand(SmartLock lock) {
        this.lock = lock;
    }

    @Override
    public void execute() {
        lock.unlock();
    }
}
