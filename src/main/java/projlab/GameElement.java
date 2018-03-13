package projlab;

//TODO: Add Javadoc
public abstract class GameElement implements ICollide {
    protected Field owner;

    public GameElement() {
        owner = null;
    }

    public GameElement(Field field) {
        owner = field;
    }

    abstract public boolean collide(Player player, Direction direction);

    abstract public boolean collide(Box box, Direction direction);

    abstract public boolean getCanMove();

    abstract public void lockRequest();
}
