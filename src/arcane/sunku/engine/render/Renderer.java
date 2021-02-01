package arcane.sunku.engine.render;

import arcane.sunku.engine.Window;
import arcane.sunku.engine.states.StateManager;

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

    public void process(Window window, StateManager stateManager) {
        BufferStrategy bufferStrategy = window.getBufferStrategy();

        if(bufferStrategy == null) {
            window.createBufferStrategy(2);
            return;
        }

        try {
            DrawGraphics = bufferStrategy.getDrawGraphics();

            DrawGraphics.setColor(Color.BLACK);
            DrawGraphics.clearRect(0, 0, Width, Height);
            DrawGraphics.fillRect(0, 0, Width, Height);

            stateManager.render();
        } finally {
            DrawGraphics.dispose();
            bufferStrategy.show();
        }
    }

    public static void drawImage(BufferedImage image, int x, int y, int width, int height) {
        DrawGraphics.drawImage(image, x, y, width, height, null);
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



}
