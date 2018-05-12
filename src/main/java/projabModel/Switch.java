package projabModel;

/**
 * <h1>Switch</h1>
 * This is a special Field object.
 * Every switch is connected to a hole.
 */
public class Switch extends Field {

    /**
     * The Hole object connected to this switch.
     */
    private Hole pair;

    /**
     * Constructor. Calls the Fields constructor
     * and sets the pair to null.
     */
    Switch() {
        super();
        pair = null;
        //System.out.println("\tSwitch created");
    }

    //TODO: Warehouse must set hole's is hole open properly before using it as a parameter

    /**
     * This method sets the Hole connected to this Switch.
     *
     * @param pair The Hole object connected to this Switch.
     */
    void setPair(Hole pair) {
        // System.out.println("\tSwitch setPair()");
        this.pair = pair;
    }

    //TODO: fix this

    /**
     * This method opens the connected hole when a box has
     * moved to it. Then calls the Fields onStepped
     * method with the box and direction given.
     */
    @Override
    public boolean onStepped(Box box, Direction direction, double power) {
        //System.out.println(String.format("\tSwitch onStepped(box, %s)", direction));
        pair.switchHole();
        return super.onStepped(box, direction, power);
    }

    /**
     * This method closes the connected whole when a
     * box moves from it. Then calls the Fields
     * offStepped method with the box and direction.
     *
     * @see Field#offStepped(Box, Direction)
     */
    @Override
    public Field offStepped(Box box, Direction direction) {
        //System.out.println(String.format("\tSwitch offStepped(box, %s)", direction));
        pair.switchHole();
        return super.offStepped(box, direction);
    }

    //TODO: Delete this

    /**
     * Overrides the toString() method to make it
     * easier to use for logging purposes.
     */
    @Override
    public String toString() {
        if (gameElement == null) {
            return "Switch";
        } else {
            return gameElement.toString();
        }
    }
}
