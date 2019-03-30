package arcane.sunku.engine;

import arcane.sunku.engine.audio.MusicPlayer;
import arcane.sunku.engine.states.StateManager;
import arcane.sunku.engine.utilities.Input;

public class Handler {

    private Input input;

    private static MusicPlayer player;
    private static StateManager sm;
    private static Window window;

    public Handler(StateManager sm, Window window) {
        Handler.sm = sm;
        Handler.window = window;

        input = new Input(window);
        player = new MusicPlayer("softly_falling.ogg");
    }

    public void update() {
        input.update();
    }

    public static void switchState(int state) {
        sm.setState(state);
        sm.initialize();
    }

    public static MusicPlayer getPlayer() { return player; }

    public static int getWidth() {
        return window.getWidth();
    }
    public static int getHeight() {
        return window.getHeight();
    }
}
