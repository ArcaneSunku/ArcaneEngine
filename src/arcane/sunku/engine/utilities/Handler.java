package arcane.sunku.engine.utilities;

import arcane.sunku.engine.audio.MusicPlayer;
import arcane.sunku.engine.render.Window;
import arcane.sunku.engine.scenes.SceneManager;

public class Handler {

    private static MusicPlayer player;
    private static SceneManager states;
    private static Window parentWindow;

    public Handler(SceneManager sceneManager) {
        states = sceneManager;
        parentWindow = Window.get();

        player = new MusicPlayer("softly_falling.ogg");
    }

    public static void switchState(int state) {
        states.setScene(state);
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
