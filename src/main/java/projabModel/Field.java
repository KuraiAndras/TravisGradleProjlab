package projabModel;

import java.util.HashMap;

/**
 * <h1>Field</h1>
 * This is a Field object in the game.
 * A map in the game is a grid of Field objects.
 */
public class Field implements IStep {

    private static double referenceStickiness = 1;
    /**
     * The GameElement that stands on the field.
     */
    GameElement gameElement;
    /**
     * This HashMap contains all the
     * neighbours of the current field
     * in the possible directions.
     */
    private HashMap<Direction, Field> neighbours;
    private double stickiness;

    /**
     * Constructor. It makes an empty HashMap
     * for the neighbours and sets the currently
     * stored GameElement to null.
     */
    public Field() {
        //System.out.println("\tField created");
        neighbours = new HashMap<>();
        gameElement = null;
        stickiness = referenceStickiness;
    }

    public double getStickiness() {
        return stickiness;
    }

    public boolean setStickiness(double newStickiness) {
        if (this.stickiness != referenceStickiness) {
            return false;
        } else {
            stickiness = newStickiness;
            return true;
        }
    }

    /**
     * This method sets the GameElement stored
     * on the field.
     *
     * @param gameElement The GameElement we want to store.
     */
    public void setGameElement(GameElement gameElement) {
        //System.out.println(String.format("\tField setGameElement(%s)", gameElement));
        this.gameElement = gameElement;
    }

    /**
     * This method checks if the stored GameElement
     * can move.
     *
     * @return False if the GameElement can't move, else true.
     */
    public boolean canElementMove() {
        //System.out.println("\tField canElementMove()");
        return gameElement.getCanMove();
    }

    /**
     * This method checks if the field
     * stores any GameElement.
     *
     * @return Returns true if there is a GameElement, else returns false.
     */
    public boolean hasElement() {
        //System.out.println("\tField hasElement()");
        return gameElement != null;
    }

    /**
     * This method calls the lockRequest() method
     * on the stored GameElement.
     */
    public void lockElement() {
        //System.out.println("\tField lockElement()");
        gameElement.lockRequest();
    }

    /**
     * This method sets the given field paired with
     * the given direction.
     *
     * @param field     The neighbour field.
     * @param direction The direction to the field.
     */
    public void setNeighbour(Field field, Direction direction) {
        //System.out.println("\tField setNeighbour()");
        neighbours.put(direction, field);
    }

    /**
     * This method returns with the neighbours
     *
     * @return neighbours The HashMap containing the neighbour fields and directions.
     */
    public HashMap<Direction, Field> getNeighbours() {
        //System.out.println("\tField getNeighbours()");
        return neighbours;
    }

    /**
     * This method collides the Player
     * stepping on it with the GameElement
     * already stored. If there is no currently
     * stored GameElement, it stores the Player
     * and returns true indicating its move was
     * successful.
     *
     * @param player    The player stepping on the field.
     * @param direction The direction of the player.
     * @return Returns true if the move was completed, else false.
     */
    @Override
    public boolean onStepped(Player player, Direction direction, double power) {
        // System.out.println("\tField onStepped(player, direction)");
        if (gameElement == null) {
            gameElement = player;
            return true;
        }
        if (gameElement.collide(player, direction, power)) {
            if (Game.getInstance().checkPlayerVitality(player))
                gameElement = player;
            Game.getInstance().doLockManagement();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method collides the Box
     * stepping on it with the GameElement
     * already stored. If there is no currently
     * stored GameElement, it stores the Box
     * and returns true indicating its move was
     * successful.
     *
     * @param box       The box stepping on the field.
     * @param direction The direction of the box
     * @return Returns true if the move was completed, else false.
     */
    @Override
    public boolean onStepped(Box box, Direction direction, double power) {
        //  System.out.println("\tField onStepped(box, direction)");
        if (gameElement == null) {
            gameElement = box;
            return true;
        }
        if (gameElement.collide(box, direction, power)) {
            gameElement = box;
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called when the stored
     * Player moves from this field.
     * It sets the currently stored GameElement
     * to null and returns a reference to the
     * neighbour field in the given direction.
     *
     * @param player    The currently stored player.
     * @param direction The direction of the player.
     * @return Returns the neighbour field in the given direction.
     */
    @Override
    public Field offStepped(Player player, Direction direction) {
        // System.out.println("\tField offStepped(player, direction)");
        gameElement = null;
        return neighbours.get(direction);
    }

    /**
     * This method is called when the stored
     * Box moves from this field.
     * It sets the currently stored GameElement
     * to null and returns a reference to the
     * neighbour field in the given direction.
     *
     * @param box       The currently stored box.
     * @param direction The direction of the box.
     * @return Returns the neighbour field in the given direction.
     */
    @Override
    public Field offStepped(Box box, Direction direction) {
        //  System.out.println("\tField offStepped(box, direction)");
        gameElement = null;
        return neighbours.get(direction);
    }

    //TODO: Delete this

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        String name="";
        if(hasElement()){
            name=name.concat(gameElement.toString().concat("On"));
        }
        name=name.concat("Field");
        if(getStickiness()<1)
            name=name.concat("WithOil");
        if(getStickiness()>1)
            name=name.concat("WithHoney");
        return name;
    }

}
