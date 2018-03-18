package projlab;

/**
 * <h1>Player</h1>
 * This is a GameElement that represents a Player
 * in the game.
 */
public class Player extends GameElement implements IPlayable {

    /**
     * Constructor. This method calls the GameElement
     * constructor with the given field and sets the
     * canMove attribute to true as default.
     *
     * @param field The field object to store the player.
     */
    public Player(Field field) {
        super(field);
        //System.out.println("\tPlayer created with field given");
    }

    /**
     * This method calls the onPlayerDead method
     * in the Game singleton. It occurs when the player
     * falls in a hole or gets pushed into a wall.
     *
     * @see Game#onPlayerDead(Player)
     */
    public void die() {
        System.out.println("\tPlayer dies");
        Game.getInstance().onPlayerDead(this);
    }

    /**
     * This method moves the player to the given direction.
     * If the player can't move to the direction, the player
     * stays on its current field.
     *
     * @param direction The direction we want the player to move.
     * @return canMove This returns true if the player was moved, false if not.
     */
    @Override
    public boolean move(Direction direction) {
        Field field1 = owner;
        Field field2 = field1.offStepped(this, direction);
        System.out.println("\tPlayer tries to move");
        if (field2.onStepped(this, direction)) {
            owner = field2;
            System.out.println("\t\tPlayer moved successfully.");
            return true;
        } else {
            field1.setGameElement(this);
            System.out.println("\t\tPlayer couldn't move.");
            return false;
        }
    }

    /**
     * This method checks if this player can be pushed by the given
     * Player object to the given direction.
     *
     * @param player    The player object that the player collides with.
     * @param direction The direction we want the player to move.
     * @return This returns false since a player cant push a player.
     */
    @Override
    public boolean collide(Player player, Direction direction) {
        System.out.println("\tPlayer collides with player.");
        return false;
    }

    /**
     * This method checks if this player can be pushed by the given
     * Box object to the given direction.
     *
     * @param box       The box object that the player collides with.
     * @param direction The direction we want the player to move.
     * @return This returns true if the player moved, false if not.
     */
    @Override
    public boolean collide(Box box, Direction direction) {
        System.out.println("\tPlayer collides with box.");
        if (this.move(direction)) {
            return true;
        } else {
            this.die();
            //This may kill the whole program?
            return false;
        }
    }

    /**
     * This method checks if the player can move
     *
     * @return canMove This returns true since the player always can move.
     */
    @Override
    public boolean getCanMove() {
        System.out.println("\tPlayer getCanMove()");
        return true;
    }

    /**
     * This method does nothing since a Player
     * always can move. Worst case the move won't
     * happen.
     */
    @Override
    public void lockRequest() {
        System.out.println("\tPlayer lockRequest()");
    }

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        return "Player";
    }
}
