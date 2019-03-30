package arcane.sunku.states;

import arcane.sunku.Assets;
import arcane.sunku.engine.Handler;
import arcane.sunku.engine.states.State;
import arcane.sunku.engine.utilities.Input;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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
    public void render(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, Handler.getWidth(), Handler.getHeight());

        g.setFont(Assets.getFont("vcr").deriveFont(Font.BOLD, 32f));
        g.setColor(Color.BLACK);
        g.drawString("In_Game", 0, 32);
    }
}
