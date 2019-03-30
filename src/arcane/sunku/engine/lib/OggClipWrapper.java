package arcane.sunku.engine.lib;

import org.newdawn.easyogg.OggClip;

import java.io.IOException;
import java.net.URL;

/**
 * @author Tom
 *
 * (http://www.java-gaming.org/index.php?action=profile;u=5098}
 * Wraps an OggClip to avoid the threading bugs in OggClip. The wrapper can be
 * played more than once at a time without problem.
 */

public class OggClipWrapper {

    private OggClip clip;
    private URL resource;
    private float gain;
    private boolean isLooping = false;

    public OggClipWrapper(URL resource, float gain) {
        this.resource = resource;
        this.gain = gain;
    }

    public void play() {
        if (clip != null && isLooping) {
            clip.stop();
        }
        isLooping = false;

        try {
            clip = new OggClip(resource.openStream());
            clip.setGain(gain);
            clip.play();
        } catch (IOException e) {
            e.printStackTrace();
            clip = null;
        }
    }

    public void stop() {
        if (clip != null) {
            isLooping = false;
            clip.stop();
            clip = null;
        }
    }

    public void loop() {
        if (clip != null && isLooping) {
            clip.stop();
        }

        try {
            clip = new OggClip(resource.openStream());
            clip.setGain(gain);
            clip.loop();
            isLooping = true;
        } catch (IOException e) {
            e.printStackTrace();
            clip = null;
        }
    }

    public void pause() {
        if (clip != null) {
            clip.pause();
        }
    }

    public void resume() {
        if (clip != null) {
            clip.resume();
        }
    }
}
