package arcane.sunku.example;

import arcane.sunku.engine.Game;
import arcane.sunku.engine.GameAdapter;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.scenes.SceneManager;
import arcane.sunku.engine.utilities.Input;
import arcane.sunku.example.scenes.MenuScene;

public class TechDemo extends GameAdapter {

    public TechDemo() {
        super("Tech Demo", 800, 800 / 16 * 9);
        renderer = new Renderer(getWidth(), getHeight());
    }

    @Override
    public void initialize() {
        Assets.initialize(); // will probably crash as it's purely for code example

        states.addScene(new MenuScene());
        switchState(0);
    }

    @Override
    public void update(double dt) {
        Input.get().update();
        states.update(dt);
    }

    @Override
    public void render() {
        renderer.process(states);
    }

    public static void main(String[] args) {
        TechDemo techDemo = new TechDemo();
        Game game = new Game(techDemo);

        game.start();
    }
}
