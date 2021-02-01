package arcane.sunku.states;

import arcane.sunku.Assets;
import arcane.sunku.TechDemo;
import arcane.sunku.engine.Handler;
import arcane.sunku.engine.audio.Sounds;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.engine.states.State;
import arcane.sunku.engine.utilities.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends State {

    @Override
    public void initialize() {
        Handler.getPlayer().changeMusic("softly_falling.ogg");

        Handler.getPlayer().changeVolume(.78f);
        Handler.getPlayer().loop();
    }

    @Override
    public void update() {
        if(Input.keyJustPressed(KeyEvent.VK_ESCAPE))
            TechDemo.running = false;

        if(Input.keyJustPressed(KeyEvent.VK_SPACE)) {
            Sounds.loopClip(Assets.getWav("confirm"), 4);
            Handler.getPlayer().pause();

            Handler.switchState(1);
        }
    }

    @Override
    public void render() {
        Renderer.setFont(Assets.getFont("vcr"), Font.BOLD, 24f);

        Renderer.setColor(Color.BLACK);
        Renderer.fillRect(0, 0, Handler.getWidth(), Handler.getHeight());
        Renderer.setColor(Color.WHITE);
        Renderer.drawString("Main_Menu", 0, 32);
    }
}
