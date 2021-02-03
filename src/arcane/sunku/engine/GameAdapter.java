package arcane.sunku.engine;

import arcane.sunku.engine.render.Renderer;

public abstract class GameAdapter implements IGame{

    private final String title;
    private final int width, height;

    protected Renderer renderer;

    public GameAdapter(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    @Override
    public void initialize() {

    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
