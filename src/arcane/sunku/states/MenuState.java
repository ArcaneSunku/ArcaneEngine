package arcane.sunku.states;

import arcane.sunku.Assets;
import arcane.sunku.TdGame;
import arcane.sunku.engine.Handler;
import arcane.sunku.engine.audio.MusicPlayer;
import arcane.sunku.engine.audio.Sounds;
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
            TdGame.running = false;

        if(Input.keyJustPressed(KeyEvent.VK_SPACE)) {
            Sounds.playClip(Assets.getWav("confirm"));
            Handler.getPlayer().pause();

            Handler.switchState(1);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setFont(Assets.getFont("vcr").deriveFont(Font.BOLD, 32f));

        g.setColor(Color.WHITE);
        g.drawString("Main_Menu", 0, 32);
    }
}
