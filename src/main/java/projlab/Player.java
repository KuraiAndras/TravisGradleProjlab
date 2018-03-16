package projlab;

//TODO: Add Javadoc
public class Player extends GameElement implements IPlayable {
    public Player(Field field) {
        super(field);
    }

    public void die() {
        Game.getInstance().onPlayerDead(this);
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
        return false;
    }

    @Override
    public boolean collide(Box box, Direction direction) {
        if (this.move(direction)) {
            return true;
        } else {
            this.die();
            //This may kill the whole program?
            return false;
        }
    }

    @Override
    public boolean getCanMove() {
        return true;
    }

    @Override
    public void lockRequest() {
    }
}
