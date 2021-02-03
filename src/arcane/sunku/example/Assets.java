package arcane.sunku.example;

import arcane.sunku.engine.audio.Sounds;
import arcane.sunku.engine.render.Fonts;
import arcane.sunku.engine.render.Images;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    private static final Map<String, Clip> SoundCache = new HashMap<>();
    private static final Map<String, Font> FontCache = new HashMap<>();
    private static final Map<String, BufferedImage> ImageCache = new HashMap<>();

    public static void initialize() {
        SoundCache.put("confirm", Sounds.loadClip("confirm.wav"));

        FontCache.put("vcr", Fonts.loadTTF("vcr.ttf"));

        ImageCache.put("wolf", Images.loadImage("wolf.png"));
    }

    public static Clip getSoundEffect(String name) {
        if(!SoundCache.containsKey(name))
            throw new RuntimeException("Failed to find file [" + name + "]!");

        return SoundCache.get(name);
    }

    public static Font getFont(String name) {
        if(!FontCache.containsKey(name))
            throw new RuntimeException("Failed to find file [" + name + "]!");

        return FontCache.get(name);
    }

    public static BufferedImage getImage(String name) {
        if(!ImageCache.containsKey(name))
            throw new RuntimeException("Failed to find file [" + name + "]!");

        return ImageCache.get(name);
    }

}
