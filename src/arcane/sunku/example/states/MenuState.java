package arcane.sunku.example.states;

import arcane.sunku.engine.ecs.GameObject;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.states.State;
import arcane.sunku.example.entity.Player;
import arcane.sunku.example.render.Texture;

import java.awt.*;

public class MenuState extends State {

    private Player mPlayer;

    @Override
    public void initialize() {
        mPlayer = new Player(0, 0, 32, 64);
    }

    @Override
    public void update(double dt) {
        mPlayer.x += 15 * dt;

        mPlayer.update(dt);
    }

    @Override
    public void render() {
        mPlayer.render();
    }
}
