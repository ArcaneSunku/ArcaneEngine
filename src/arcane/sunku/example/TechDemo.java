package arcane.sunku.example;

import arcane.sunku.engine.Game;
import arcane.sunku.engine.GameAdapter;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.scenes.SceneManager;
import arcane.sunku.engine.utilities.Handler;
import arcane.sunku.engine.utilities.Input;
import arcane.sunku.example.scenes.MenuScene;

public class TechDemo extends GameAdapter {
    private final SceneManager sceneManager;

    private Handler handler;

    public TechDemo() {
        super("Tech Demo", 800, 800 / 16 * 9);
        renderer = new Renderer(getWidth(), getHeight());
        sceneManager = new SceneManager();
    }

    @Override
    public void initialize() {
        handler = new Handler(sceneManager);
        Assets.initialize(); // will probably crash as it's purely for code example

        sceneManager.addScene(new MenuScene());
        Handler.switchState(0);
    }

    @Override
    public void update(double dt) {
        Input.get().update();
        sceneManager.update(dt);
    }

    @Override
    public void render() {
        renderer.process(sceneManager);
    }

    public static void main(String[] args) {
        TechDemo techDemo = new TechDemo();
        Game game = new Game(techDemo);

        game.start();
    }
}
