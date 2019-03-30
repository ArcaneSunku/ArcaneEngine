package arcane.sunku.engine.states;

import java.awt.Graphics2D;

public abstract class State {

    public abstract void initialize();
    public abstract void update();
    public abstract void render(Graphics2D g);

}
