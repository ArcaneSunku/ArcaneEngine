package arcane.sunku.example;

import arcane.sunku.engine.Game;
import arcane.sunku.engine.GameAdapter;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.states.StateManager;
import arcane.sunku.engine.utilities.Handler;
import arcane.sunku.example.states.MenuState;

public class TechDemo extends GameAdapter {
    private final StateManager stateManager;

    private Handler handler;

    public TechDemo() {
        super("Tech Demo", 800, 800 / 16 * 9);
        renderer = new Renderer(getWidth(), getHeight());
        stateManager = new StateManager();
    }

    @Override
    public void initialize() {
        handler = new Handler(stateManager, Game.getWindow());
        Assets.initialize(); // will probably crash as it's purely for code example

        stateManager.addState(new MenuState());
        Handler.switchState(0);
    }

    @Override
    public void update(double dt) {
        handler.update();
        stateManager.update(dt);
    }

    @Override
    public void render() {
        renderer.process(Game.getWindow(), stateManager);
    }

    public static void main(String[] args) {
        TechDemo techDemo = new TechDemo();
        Game game = new Game(techDemo);

        game.start();
    }
}
