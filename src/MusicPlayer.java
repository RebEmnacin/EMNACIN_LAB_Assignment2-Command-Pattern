/**
 * Receiver class for the music player device.
 */
public class MusicPlayer {
    private int volume; // 0-100
    private String currentPlaylist;
    private boolean isPlaying;

    public MusicPlayer() {
        this.volume = 50;
        this.currentPlaylist = null;
        this.isPlaying = false;
    }

    public void play(String playlist) {
        this.currentPlaylist = playlist;
        this.isPlaying = true;
        System.out.println("[MusicPlayer] now playing playlist: \"" + playlist + "\" (volume: " + volume + ")");
    }

    public void stop() {
        this.isPlaying = false;
        System.out.println("[MusicPlayer] stopped");
    }

    public void volumeUp() {
        volume = Math.min(100, volume + 10);
        System.out.println("[MusicPlayer] volume up -> " + volume);
    }

    public void volumeDown() {
        volume = Math.max(0, volume - 10);
        System.out.println("[MusicPlayer] volume down -> " + volume);
    }
}
