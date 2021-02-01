package arcane.sunku.engine.states;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StateManager {

    private List<State> states;
    private int currState;

    public StateManager() { states = new ArrayList<>(); }

    public void initialize() { states.get(currState).initialize(); }
    public void update() { states.get(currState).update(); }
    public void render() { states.get(currState).render(); }

    public void addState(State state) { states.add(state); }
    public void removeState(int index) {
        states.remove(index);
    }
    public void setState(int stateIndex) {
        currState = stateIndex;
    }

}
