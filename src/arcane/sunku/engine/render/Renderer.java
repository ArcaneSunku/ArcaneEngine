package arcane.sunku.engine.render;

import arcane.sunku.engine.Game;
import arcane.sunku.engine.scenes.SceneManager;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Renderer {

    private static Graphics DrawGraphics;
    private final int Width, Height;

    public Renderer(int width, int height) {
        this.Width = width;
        this.Height = height;
    }

    public void process(SceneManager sceneManager) {
        if(Window.get() != null) {
            BufferStrategy bufferStrategy = Window.get().getBufferStrategy();

            if (bufferStrategy == null) {
                Window.get().createBufferStrategy(2);
                return;
            }

            try {
                DrawGraphics = bufferStrategy.getDrawGraphics();

                DrawGraphics.setColor(Color.BLACK);
                DrawGraphics.clearRect(0, 0, Width, Height);
                DrawGraphics.fillRect(0, 0, Width, Height);

                sceneManager.render();
            } finally {
                DrawGraphics.dispose();
                bufferStrategy.show();
            }
        }
    }

    public static void drawImage(BufferedImage image, int x, int y, int width, int height) {
        DrawGraphics.drawImage(image, x, y, width, height, null);
    }

    public static void drawImage(BufferedImage image, int x, int y) {
        DrawGraphics.drawImage(image, x, y, null);
    }

    public static void drawString(String string, int x, int y) {
        DrawGraphics.drawString(string, x, y);
    }

    public static void fillRect(int x, int y, int width, int height) {
        DrawGraphics.fillRect(x, y, width, height);
    }

    public static void setColor(int red, int green, int blue, int alpha) {
        setColor(new Color(red, green, blue, alpha));
    }

    public static void setColor(int red, int green, int blue) {
        setColor(red, green, blue, 255);
    }

    public static void setColor(Color color) {
        DrawGraphics.setColor(color);
    }

    public static void setFont(Font font, int style, float size) {
        DrawGraphics.setFont(font.deriveFont(style, size));
    }

    public static void setFont(Font font, float size) {
        setFont(font, Font.PLAIN, size);
    }

    public static void setFont(Font font) {
        setFont(font, 24f);
    }

    public static int getFontHeight() {
        return DrawGraphics.getFontMetrics(DrawGraphics.getFont()).getHeight();
    }

    public static int getFontWidth(String str) {
        return DrawGraphics.getFontMetrics(DrawGraphics.getFont()).stringWidth(str);
    }

}
