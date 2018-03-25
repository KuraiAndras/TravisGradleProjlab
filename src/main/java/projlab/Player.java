package projlab;

import java.util.Random;

/**
 * <h1>Player</h1>
 * This is a GameElement that represents a Player
 * in the game.
 */
public class Player extends GameElement implements IPlayable, IMovable {

    private double power;

    /**
     * Constructor. This method calls the GameElement
     * constructor with the given field and sets the
     * canMove attribute to true as default.
     *
     * @param field The field object to store the player.
     */
    public Player(Field field) {
        super(field);
        //Random power value for player within reasons
        double random = new Random().nextDouble();
        power = 5.1 + (random * (6.5 - 5.1));
        weight = 0.5;
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
        //System.out.println("\tPlayer dies");
        owner.setGameElement(null);     //For more than 2 players,the corpse must be removed so that the game can continue
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
    public boolean move(Direction direction, double power) {
        double decreasedPower = power - weight * owner.getStickiness();

        if (decreasedPower <= 0) {
            //System.out.println("\tNthPlayer says Player power too low");
            return false;
        }

        System.out.println("\tPlayer tries to move");

        Field field1 = owner;
        Field field2 = field1.offStepped(this, direction);

        if (field2.onStepped(this, direction, decreasedPower)) {
            owner = field2;
            //System.out.println("\t\tPlayer moved successfully.");
            return true;
        } else {
            field1.setGameElement(this);
            //System.out.println("\t\tPlayer couldn't move.");
            return false;
        }
    }

    @Override
    public boolean move(Direction direction) {
        return move(direction, (power + weight) * owner.getStickiness());
    }

    @Override
    public boolean placeSticky(double stickiness) {
        return owner.setStickiness(stickiness);
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
    public boolean collide(Player player, Direction direction, double power) {
        //System.out.println("\tPlayer collides with player.");
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
    public boolean collide(Box box, Direction direction, double power) {
        //System.out.println("\tPlayer collides with box.");
        if (this.move(direction, power)) {
            return true;
        } else {
            this.die();
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
//        System.out.println("\tPlayer getCanMove()");
        return true;
    }

    /**
     * This method does nothing since a Player
     * always can move. Worst case the move won't
     * happen.
     */
    @Override
    public void lockRequest() {
        //System.out.println("\tPlayer lockRequest()");
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
