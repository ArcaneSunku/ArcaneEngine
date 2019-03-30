package arcane.sunku.ui;

import arcane.sunku.engine.graphics.UI;

import java.awt.image.BufferedImage;

public abstract class Menu extends UI {

    protected int width, height;

    public Menu(int width, int height, BufferedImage texture) {
        super(texture);
    }

    public abstract void update();

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
