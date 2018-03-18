package projlab;

/**
 * <h1>Wall</h1>
 * This is a GameElement that represents a Wall
 * in the game.
 */
public class Wall extends GameElement {

    /**
     * Constructor. This method calls the GameElement
     * constructor with the given field.
     *
     * @param field The field object to store the wall.
     */
    public Wall(Field field) {
        super(field);
        //System.out.println("\tWall created with field given");
    }

    /**
     * This method checks if this wall can be pushed by the given
     * Player object to the given direction.
     *
     * @param player    The player object that the wall collides with.
     * @param direction The direction we want the wall to move.
     * @return This method always returns false.
     */
    @Override
    public boolean collide(Player player, Direction direction) {
        System.out.println("\tWall collides with player");
        return false;
    }

    /**
     * This method checks if this wall can be pushed by the given
     * Box object to the given direction.
     *
     * @param box       The player object that the wall collides with.
     * @param direction The direction we want the wall to move.
     * @return This method always returns false.
     */
    @Override
    public boolean collide(Box box, Direction direction) {
        System.out.println("\tWall collides with box");
        return false;
    }

    /**
     * This method checks if the wall can move.
     *
     * @return This returns false since the wall can't move.
     */
    @Override
    public boolean getCanMove() {
        //System.out.println("\tWall getCanMove()");
        return false;
    }

    /**
     * This method does nothing since the wall is already locked.
     */
    @Override
    public void lockRequest() {
        //System.out.println("\tWall lockRequest()");
    }

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        return "Wall";
    }

    /**
     * This method destroy the wall from the field
     * Potential for a new feature.
     */
    @Override
    public void die(){
        System.out.println("\tWall die()");
        owner.setGameElement(null);
    }
}
