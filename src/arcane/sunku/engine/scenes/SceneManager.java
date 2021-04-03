package arcane.sunku.engine.scenes;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {

    private List<Scene> scenes;
    private int currState;

    public SceneManager() { scenes = new ArrayList<>(); }

    public void initialize() { scenes.get(currState).initialize(); }
    public void update(double dt) { scenes.get(currState).update(dt); }
    public void render() { scenes.get(currState).render(); }

    public void addState(Scene scene) { scenes.add(scene); }
    public void removeState(int index) {
        scenes.remove(index);
    }
    public void setState(int stateIndex) {
        currState = stateIndex;
    }

}
