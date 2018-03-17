package projlab;

/**
 * <h1>Hole</h1>
 * This is a special Field object.
 * Every hole is connected to a switch.
 */
public class Hole extends Field {

    /**
     * True if the hole is open,
     * false if it is closed.
     */
    private boolean isOpen;

    /**
     * Constructor. Calls the Fields
     * constructor and sets
     * isOpen to the given value.
     *
     * @param isOpen Returns the value of isOpen.
     */
    public Hole(boolean isOpen) {
        super();
        this.isOpen = isOpen;
        System.out.println("\tHole created");
    }

    /**
     * This method closes the open Hole
     * and opens the closed one.
     */
    public void switchHole() {
        isOpen = !isOpen;
        if(isOpen==true && gameElement!=null)
            gameElement=null;
        System.out.println("\tHole switchHole()");
    }

    /**
     * This method is called when a Player steps
     * on it. If the hole is open it kills the player.
     * If it is closed it calls the Fields
     * onStepped(player, direction) method and returns
     * its value.
     *
     * @see Field#onStepped(Player, Direction)
     */
    @Override
    public boolean onStepped(Player player, Direction direction) {
        System.out.println("\tHole onStepped(player, direction)");
        if (!isOpen) {
            return super.onStepped(player, direction);
        } else {
            player.die();
            //This may kill the whole program?
            return false;
        }
    }

    /**
     * This method is called when a Box steps
     * on it. If the hole is open it destroys the
     * box and decreases the games movableBox count by one.
     * If it is closed it calls the Fields
     * onStepped(player, direction) method and returns
     * its value.
     *
     * @see Field#onStepped(Box, Direction)
     */
    @Override
    public boolean onStepped(Box box, Direction direction) {
        System.out.println("\tHole onStepped(box, direction)");
        if (!super.onStepped(box, direction))
            return false;
        else {
            if (isOpen) {
                gameElement = null;
                Game.getInstance().decreaseMovableBox();
            }
            return true;
        }
    }
    //TODO: Delete this

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        if (gameElement == null) {
            return "Hole";
        } else {
            return gameElement.toString();
        }
    }
}
