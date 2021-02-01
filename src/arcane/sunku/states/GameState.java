package arcane.sunku.states;

import arcane.sunku.Assets;
import arcane.sunku.engine.Handler;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.states.State;
import arcane.sunku.engine.utilities.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameState extends State {

    @Override
    public void initialize() {
        Handler.getPlayer().changeMusic("bloomed_dawn.ogg");

        Handler.getPlayer().changeVolume(0.78f);
        Handler.getPlayer().loop();
    }

    @Override
    public void update() {
        if(Input.keyJustPressed(KeyEvent.VK_ESCAPE)) {
            Handler.getPlayer().pause();
            Handler.switchState(0);
        }
    }

    @Override
    public void render() {
        Renderer.setColor(Color.LIGHT_GRAY);
        Renderer.fillRect(0, 0, Handler.getWidth(), Handler.getHeight());

        Renderer.drawImage(Assets.getImage("wolf"), 42, 42, 32, 64);

        Renderer.setFont(Assets.getFont("vcr"), Font.BOLD, 24f);
        Renderer.setColor(Color.BLACK);
        Renderer.drawString("In_Game", 0, 32);
    }
}
