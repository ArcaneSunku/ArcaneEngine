package arcane.sunku.engine.render;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {

    public static BufferedImage loadImage(String path) {
        BufferedImage buffered_image = null;

        try {
            buffered_image = ImageIO.read(Images.class.getResourceAsStream("/assets/textures/" + path));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("ERROR::GRAPHICS::Images Failed to load [%s]!%n", path);
        }

        return (buffered_image == null) ? null : toCompatibleImage(buffered_image);
    }

    public static BufferedImage toCompatibleImage(BufferedImage image)
    {
        // obtain the current system graphical settings
        GraphicsConfiguration graphics_configuration = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getDefaultScreenDevice().
                getDefaultConfiguration();

        /*
         * if image is already compatible and optimized for current system
         * settings, simply return it
         */
        if (image.getColorModel().equals(graphics_configuration.getColorModel()))
            return image;

        // image is not optimized, so create a new image that is
        BufferedImage new_image = graphics_configuration.createCompatibleImage(
                image.getWidth(), image.getHeight(), image.getTransparency());

        // get the graphics context of the new image to draw the old image on
        Graphics2D g2d = new_image.createGraphics();

        // actually draw the image and dispose of context no longer needed
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        // return the new optimized image
        return new_image;
    }

}
