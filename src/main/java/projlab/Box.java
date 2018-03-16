package projlab;

//TODO: Add Javadoc
public class Box extends GameElement implements IPlayable {
    private boolean canMove;

    public Box() {
        super();
        canMove = true;
    }

    public Box(Field field) {
        super(field);
        canMove = true;
    }

    @Override
    public void lockRequest() {
        canMove = false;
        Game.getInstance().decreaseMovableBox();
    }

    @Override
    public boolean getCanMove() {
        return canMove;
    }

    @Override
    public boolean move(Direction direction) {
        Field field1 = owner;
        Field field2 = field1.offStepped(this, direction);
        if (field2.onStepped(this, direction)) {
            owner = field2;
            return true;
        } else {
            field1.setGameElement(this);
            return false;
        }
    }

    @Override
    public boolean collide(Player player, Direction direction) {
        return canMove && move(direction);
    }

    @Override
    public boolean collide(Box box, Direction direction) {
        return canMove && move(direction);
    }

    @Override
    public String toString() {
        return "Box ";
    }
}
