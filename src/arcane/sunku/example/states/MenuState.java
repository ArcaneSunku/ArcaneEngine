package arcane.sunku.example.states;

import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.states.State;

import java.awt.*;

public class MenuState extends State {
    @Override
    public void initialize() {

    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void render() {
        Renderer.setColor(Color.RED);
        Renderer.fillRect(42, 42, 64, 64);
    }
}
