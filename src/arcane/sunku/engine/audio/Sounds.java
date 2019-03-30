package arcane.sunku.engine.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sounds {

    public static Clip loadClip(String fileName) {
        AudioInputStream audioIn = null;
        Clip in = null;

        try {
            URL url = Sounds.class.getResource("/assets/audio/se/" + fileName);
            audioIn = AudioSystem.getAudioInputStream(url);
            in = AudioSystem.getClip();
            in.open(audioIn);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.printf("Audio::ERR Couldn't load file \"%s\"\n", fileName);
        } finally {
            try {
                audioIn.close();
            } catch (IOException e) {
                System.err.println("Audio::ERR Couldn't close AudioInputStream!");
            }
        }

        return in;
    }

    private static void playClip(Clip clip, boolean loop, int loopCount) {
        if(clip.isRunning())
            clip.stop();

        clip.setFramePosition(0);

        if(loop && loopCount == 0)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else if(loop)
            clip.loop(loopCount);

        clip.start();
    }

    public static void playClip(Clip clip) {
        playClip(clip, false, 0);
    }

    public static void loopClip(Clip clip) {
        playClip(clip, true, 0);
    }
}
