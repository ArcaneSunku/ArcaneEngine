package arcane.sunku.example.scenes;

import arcane.sunku.engine.scenes.Scene;
import arcane.sunku.example.entity.Player;

public class MenuScene extends Scene {

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
