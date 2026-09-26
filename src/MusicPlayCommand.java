public class MusicPlayCommand implements Command 
{
    private MusicPlayer player;
    private String playlist;

    public MusicPlayCommand(MusicPlayer player, String playlist) 
    {
        this.player = player;
        this.playlist = playlist;
    }

    @Override
    public void execute() 
    {
        player.play(playlist);
    }
}
