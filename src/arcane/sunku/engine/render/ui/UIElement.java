package arcane.sunku.engine.render.ui;

import java.awt.image.BufferedImage;

public abstract class UIElement implements UI {

    protected final ElementType type;

    protected BufferedImage texture;

    protected float xPos, yPos;
    protected int width, height;

    public UIElement(ElementType type, float xPos, float yPos, int width, int height) {
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;

        this.width = width;
        this.height = height;
    }

    public UIElement(BufferedImage texture, ElementType type, float xPos, float yPos, int width, int height) {
        this(type, xPos, yPos, width, height);
        this.texture = texture;
    }

    public void setPosition(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ElementType getType() {
        return type;
    }

}
