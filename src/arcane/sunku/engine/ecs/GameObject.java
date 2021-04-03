package arcane.sunku.engine.ecs;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

    protected final String mTag;
    protected final List<Component> mChildren;

    public GameObject(String tag) {
        mTag = tag;
        mChildren = new ArrayList<>();
    }

    public void update(double dt) {
        updateComponents(dt);
    }

    public void render() {
        renderComponents();
    }

    public void updateComponents(double dt) {
        if(mChildren.isEmpty())
            return;

        for(Component child : mChildren) {
            if(child == null)
                continue;

            child.update(dt);
        }
    }

    public void renderComponents() {
        if(mChildren.isEmpty())
            return;

        for(Component child : mChildren) {
            if(child == null)
                continue;

            child.render();
        }
    }

    public void addComponent(Component component) {
        mChildren.add(component);
    }

    public void removeComponent(Component component) {
        for(Component child : mChildren) {
            if(child.equals(component))
                mChildren.remove(component);
        }
    }

    public void removeComponent(String tag) {
        mChildren.removeIf(child -> mTag.equalsIgnoreCase(tag));
    }

    public Component getComponent(String tag) {
        Component target = null;
        for(Component child : mChildren) {
            if (child.mTag.equalsIgnoreCase(tag)) {
                target = child;
                break;
            }
        }

        return target;
    }

    public boolean isComponent() {
        return (this instanceof Component);
    }

}
