package projlab;

//TODO: Add Javadoc
public class Wall extends GameElement {

    public Wall(Field field) {
        super(field);
    }

    @Override
    public boolean collide(Player player, Direction direction) {
        return false;
    }

    @Override
    public boolean collide(Box box, Direction direction) {
        return false;
    }

    @Override
    public boolean getCanMove() {
        return false;
    }

    @Override
    public void lockRequest() {
    }

    @Override
    public String toString() {
        return "Wall";
    }
}
