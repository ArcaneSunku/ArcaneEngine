package arcane.sunku.engine.ecs;

public abstract class Component extends GameObject {

    protected GameObject mParent;

    public Component(String tag) {
        super(tag);
    }

    public GameObject getParent() {
        return mParent;
    }

    public void setParent(GameObject parent) {
        if(parent.isComponent()) {
            System.out.println("You can't set ");
        }

        mParent = parent;
    }

}
