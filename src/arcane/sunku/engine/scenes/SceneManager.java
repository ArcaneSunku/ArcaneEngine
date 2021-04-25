package arcane.sunku.engine.scenes;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    private final List<Scene> mScenes;
    private int mCurrentState;

    public SceneManager() { mScenes = new ArrayList<>(); }

    public void initialize() { mScenes.get(mCurrentState).initialize(); }
    public void update(double dt) { mScenes.get(mCurrentState).update(dt); }
    public void render() { mScenes.get(mCurrentState).render(); }

    public void addScene(Scene scene) { mScenes.add(scene); }
    public void removeScene(int scene) {
        mScenes.remove(scene);
    }
    public void setScene(int scene) {
        mCurrentState = scene;
    }

}
