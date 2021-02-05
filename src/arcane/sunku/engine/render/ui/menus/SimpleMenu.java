package arcane.sunku.engine.render.ui.menus;

import arcane.sunku.engine.render.ui.Menu;

import java.awt.image.BufferedImage;

public class SimpleMenu extends Menu {
    public SimpleMenu(float xPos, float yPos, int width, int height) {
        super(xPos, yPos, width, height);
    }

    public SimpleMenu(BufferedImage texture, float xPos, float yPos, int width, int height) {
        super(texture, xPos, yPos, width, height);
    }

    @Override
    public void draw() {

        drawElements();
    }

    @Override
    public void update() {

        updateElements();
    }
}
