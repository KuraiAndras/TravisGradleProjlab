package projlab;

/**
 * <h1>GameElement</h1>
 * This represents an abstract GameElement
 * in the game.
 */
public abstract class GameElement implements ICollide {

    /**
     * The Field object the GameElement stands on.
     */
    protected Field owner;

    protected double weight;

    /**
     * Constructor. This method creates a GameElement
     * and sets its owner to null by default.
     */
    public GameElement() {
        System.out.println("\tGameElement created");
        owner = null;
        weight = 0;
    }

    /**
     * Constructor. This method creates a GameElement
     * and sets its owner to the given Field object.
     *
     * @param field The field object to store the GameElement.
     */
    public GameElement(Field field) {
        //System.out.println("\tGameElement created with given field");
        weight = 0;
        owner = field;
    }

    /**
     * This method checks if this GameElement can be pushed by the given
     * Player object to the given direction.
     *
     * @param player    The player object that the GameElement collides with.
     * @param direction The direction we want the GameElement to move.
     * @return This returns true if the GameElement moved, false if not.
     */
    abstract public boolean collide(Player player, Direction direction, double power);

    /**
     * This method checks if this GameElement can be pushed by the given
     * box object to the given direction.
     *
     * @param box       The box object that the GameElement collides with.
     * @param direction The direction we want the GameElement to move.
     * @return This returns true if the GameElement moved, false if not.
     */
    abstract public boolean collide(Box box, Direction direction, double power);

    /**
     * This method checks if the GameElement can move
     *
     * @return canMove This returns true if the GameElement can move.
     */
    abstract public boolean getCanMove();

    /**
     * This method locks the GameElement to
     * its current position.
     */
    abstract public void lockRequest();

    /**
     * This method destroy the GameElement
     */
    abstract public void die();
}
