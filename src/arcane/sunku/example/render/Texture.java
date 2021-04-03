package arcane.sunku.example.render;

import arcane.sunku.engine.ecs.Component;
import arcane.sunku.engine.render.Renderer;
import arcane.sunku.example.Assets;

public class Texture extends Component {

    public String texture;

    public float x = 0,  y = 0;
    public int width = 32, height = 32;

    public Texture(String texture) {
        super("Texture");
        this.texture = texture;
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void render() {
        Renderer.drawImage(Assets.getImage(texture), (int) x, (int) y, width, height);
    }
}
