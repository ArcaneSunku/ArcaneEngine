package arcane.sunku.engine.render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class UI {

    protected BufferedImage texture;

    protected int xPos, yPos;

    public UI(BufferedImage texture) {
        this.texture = texture;
    }

    public abstract void draw(Graphics2D g);

    public void setPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getX() { return xPos; }
    public int getY() { return yPos; }

}
