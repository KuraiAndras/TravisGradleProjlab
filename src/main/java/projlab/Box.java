package projlab;

/**
 * <h1>Box</h1>
 * This is a GameElement that represents a Box
 * in the game.
 */
public class Box extends GameElement implements IPlayable {

    /**
     * True if the box can use the move() method, false if it is locked
     * to it's current position.
     */
    private boolean canMove;


    /**
     * Constructor. This method calls the GameElement
     * constructor and sets the canMove attribute to
     * true as default.
     */
    public Box() {
        super();
        canMove = true;
        System.out.println("\tBox created");
    }

    /**
     * Constructor. This method calls the GameElement
     * constructor with the given field and sets the
     * canMove attribute to true as default.
     *
     * @param field The field object to store the box.
     */
    public Box(Field field) {
        super(field);
        canMove = true;
        //System.out.println("\tBox created with field given");
    }

    /**
     * This method destroy the box and
     * decreases the movable box count by 1.
     */
    @Override
    public void die(){
        owner.setGameElement(null);
        Game.getInstance().decreaseMovableBox();
    }


    /**
     * This method locks the box to its current position and
     * decreases the movable box count by 1.
     */
    @Override
    public void lockRequest() {
        canMove = false;
        Game.getInstance().decreaseMovableBox();
        System.out.println("\tBox locked");
    }

    /**
     * This method checks if the box can move
     *
     * @return canMove This returns true if the box can move.
     */
    @Override
    public boolean getCanMove() {
        System.out.println("\tBox getCanMove()");
        return canMove;
    }

    /**
     * This method moves the box to the given direction.
     * If the box can't move to the direction, the box stays
     * on its current field.
     *
     * @param direction The direction we want the box to move.
     * @return canMove This returns true if the box was moved, false if not.
     */
    @Override
    public boolean move(Direction direction) {
        Field field1 = owner;
        Field field2 = field1.offStepped(this, direction);
        System.out.println("\tBox tries to move");
        if (field2.onStepped(this, direction)) {
            owner = field2;
            System.out.println("\t\tBox moved successfully.");
            return true;
        } else {
            field1.setGameElement(this);
            System.out.println("\t\tBox couldn't move.");
            return false;
        }
    }

    /**
     * This method checks if this box can be pushed by the given
     * Player object to the given direction.
     *
     * @param player    The player object that the box collides with.
     * @param direction The direction we want the box to move.
     * @return This returns true if the box moved, false if not.
     */
    @Override
    public boolean collide(Player player, Direction direction) {
        System.out.println("\tBox collides with player.");
        return canMove && move(direction);
    }

    /**
     * This method checks if this box can be pushed by the given
     * Box object to the given direction.
     *
     * @param box       The Box object that the box collides with.
     * @param direction The direction we want the box to move.
     * @return This returns true if the box moved, false if not.
     */
    @Override
    public boolean collide(Box box, Direction direction) {
        System.out.println("\tBox collides with box.");
        return canMove && move(direction);
    }

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        return "Box ";
    }
}
