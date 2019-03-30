package arcane.sunku.engine.audio;


import arcane.sunku.engine.lib.OggClipWrapper;

import java.net.URL;

public class MusicPlayer
{

    private String currentSong;
    private OggClipWrapper ogg;
    private boolean flipMute = true, playing = false;

    public MusicPlayer(String fileName)
    {
        ogg = createClip(fileName, 1);
        currentSong = fileName;
    }

    public void changeVolume(float gain) {
        close();

        ogg = createClip(currentSong, gain);
    }

    public void changeMusic(String song, boolean autoPlay) {
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
        try {
            playing = true;
            ogg.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause()
    {
        try {
            ogg.pause();
            playing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loop()
    {
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

    private OggClipWrapper createClip(String song, float gain) {
        URL url = this.getClass().getResource("/assets/audio/music/" + song);
        return new OggClipWrapper(url, gain);
    }
}