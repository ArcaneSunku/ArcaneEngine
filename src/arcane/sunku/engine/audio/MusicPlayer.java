package arcane.sunku.engine.audio;


import arcane.sunku.engine.lib.Ogg;

import java.net.URL;

public class MusicPlayer
{

    private static MusicPlayer mInstance;

    private String currentSong;
    private Ogg ogg;
    private boolean flipMute = true, playing = false;

    private MusicPlayer()
    {
        currentSong = "";
        ogg = createClip(currentSong, 1);
    }

    public static MusicPlayer get() {
        if(mInstance == null)
            mInstance = new MusicPlayer();

        return mInstance;
    }

    public void changeVolume(float gain) {
        if(ogg != null)
            close();

        ogg = createClip(currentSong, gain);
    }

    public void changeMusic(String song, boolean autoPlay) {
        if(ogg != null)
            close();

        ogg = createClip(song, 1);
        currentSong = song;

        if(autoPlay)
            play();
    }

    public void changeMusic(String song) {
        changeMusic(song, false);
    }

    public void toggleSound()
    {
        if(ogg == null) return;

        try {
            if(flipMute)
                ogg.stop();
            else
                ogg.loop();

            flipMute = !flipMute;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play()
    {
        if(ogg == null) return;

        try {
            playing = true;
            ogg.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause()
    {
        if(ogg == null) return;

        try {
            ogg.pause();
            playing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loop()
    {
        if(ogg == null) return;

        try {
            playing = true;
            ogg.loop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            pause();
            ogg.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    private Ogg createClip(String song, float gain) {
        URL url = this.getClass().getResource("/assets/audio/music/" + song);
        return new Ogg(url, gain);
    }
}