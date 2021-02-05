package arcane.sunku.engine.render.ui.elements;

import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.render.ui.ElementType;
import arcane.sunku.engine.render.ui.UIElement;
import arcane.sunku.example.Assets;

import java.awt.image.BufferedImage;

public class TextBox extends UIElement {

    public TextBox(float xPos, float yPos, int width, int height) {
        super(ElementType.TEXT_BOX, xPos, yPos, width, height);
    }

    public TextBox(BufferedImage texture, float xPos, float yPos, int width, int height) {
        super(texture, ElementType.TEXT_BOX, xPos, yPos, width, height);
    }

    @Override
    public void draw() {
        Renderer.setFont(Assets.getFont("default"), 42f);
    }

    @Override
    public void update() {
        // held for 'animations' and the like
    }
}
