package arcane.sunku.engine;

import arcane.sunku.engine.audio.MusicPlayer;
import arcane.sunku.engine.states.StateManager;
import arcane.sunku.engine.utilities.Input;

public class Handler {

    private static MusicPlayer player;
    private static StateManager states;
    private static Window parentWindow;

    private final Input input;

    public Handler(StateManager stateManager, Window window) {
        states = stateManager;
        parentWindow = window;

        input = new Input(window);
        player = new MusicPlayer("softly_falling.ogg");
    }

    public void update() {
        input.update();
    }

    public static void switchState(int state) {
        states.setState(state);
        states.initialize();
    }

    public static MusicPlayer getPlayer() {
        return player;
    }

    public static int getWidth() {
        return parentWindow.getWidth();
    }

    public static int getHeight() {
        return parentWindow.getHeight();
    }
}
