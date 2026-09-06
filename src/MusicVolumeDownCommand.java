public class MusicVolumeDownCommand implements Command {
    private MusicPlayer player;

    public MusicVolumeDownCommand(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.volumeDown();
    }
}
