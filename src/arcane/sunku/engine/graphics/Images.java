package arcane.sunku.engine.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {

    public static BufferedImage loadImage(String imageName) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream("/assets/textures/" + imageName));
        } catch (IOException e) {
            System.err.printf("Graphics::ERR Couldn't load file \"%s\"\n", imageName);
            return null;
        }
    }

}
