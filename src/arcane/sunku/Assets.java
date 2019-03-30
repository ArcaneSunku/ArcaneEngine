package arcane.sunku;

import arcane.sunku.engine.audio.Sounds;
import arcane.sunku.engine.graphics.Fonts;
import arcane.sunku.engine.graphics.Images;
import arcane.sunku.engine.utilities.LURCache;

import javax.sound.sampled.Clip;
import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

    private static LURCache<String, Font> fonts;
    private static LURCache<String, BufferedImage> images;

    private static LURCache<String, Clip> wavs;

    public static void load() {
        // Graphics
        if(fonts == null)
            fonts = LURCache.newInstance(10);

        if(images == null)
            images = LURCache.newInstance(20);

        fonts.putIfAbsent("vcr", Fonts.loadTTF("vcr.ttf"));

        images.putIfAbsent("wolf", Images.loadImage("wolf.png"));

        // Audio
        if(wavs == null)
            wavs = LURCache.newInstance(20);

        wavs.putIfAbsent("confirm", Sounds.loadClip("confirm.wav"));
    }

    public static Font getFont(String font) {
        return fonts.get(font);
    }
    public static BufferedImage getImage(String image) {
        return images.get(image);
    }

    public static Clip getWav(String wav) {
        return wavs.get(wav);
    }

}
