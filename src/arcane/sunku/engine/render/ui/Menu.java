package arcane.sunku.engine.render.ui;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public abstract class Menu implements UI {

    protected final Map<String, UIElement> uiElements;

    protected BufferedImage texture;

    protected float xPos, yPos;
    protected int width, height;

    public Menu(float xPos, float yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;

        this.width = width;
        this.height = height;

        this.uiElements = new HashMap<>();
    }

    public Menu(BufferedImage texture, float xPos, float yPos, int width, int height) {
        this(xPos, yPos, width, height);
        this.texture = texture;
    }

    public void drawElements() {
        for(UIElement e : uiElements.values()) {
            e.draw();
        }
    }

    public void updateElements() {
        for(UIElement e : uiElements.values()) {
            e.update();
        }
    }

    public void setPosition(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
