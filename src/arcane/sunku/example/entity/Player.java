package arcane.sunku.example.entity;

import arcane.sunku.engine.ecs.GameObject;
import arcane.sunku.example.render.Texture;

public class Player extends GameObject {

    public float x, y;
    public int width, height;

    public Player(int x, int y, int width, int height) {
        super("Player");

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        Texture wolf = new Texture("wolf");
        wolf.x = this.x;
        wolf.y = this.y;

        wolf.width = this.width;
        wolf.height = this.height;

        addComponent(wolf);
    }

    @Override
    public void update(double dt) {
        Texture wolf = (Texture) getComponent("Texture");

        wolf.x = x;
        wolf.y = y;

        wolf.width = width;
        wolf.height = height;
    }

}
