package arcane.sunku.engine;

import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.scenes.SceneManager;

public abstract class GameAdapter implements IGame{

    protected static SceneManager states;

    public static void switchState(int state) {
        states.setScene(state);
        states.initialize();
    }

    private final String title;
    private final int width, height;

    protected Renderer renderer;

    public GameAdapter(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        states = new SceneManager();
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
