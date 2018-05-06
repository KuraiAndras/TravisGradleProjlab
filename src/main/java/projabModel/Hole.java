package projabModel;

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
    Hole(boolean isOpen) {
        super();
        this.isOpen = isOpen;
        //System.out.println("\tHole created");
    }

    /**
     * This method closes the open Hole
     * and opens the closed one.
     * If there is something when it open,
     * then it destroy it.
     */
    public void switchHole() {
        isOpen = !isOpen;
        if (isOpen && gameElement != null)       //Azok amik függetlenek a tolástól
            gameElement.die();
        // System.out.println("\tHole switchHole()");
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    //TODO: Fix this

    /**
     * This method is called when a Player steps
     * on it. If the hole is open it kills the player.
     * If it is closed it calls the Fields
     * onStepped(player, direction) method and returns
     * its value.
     */
    @Override
    public boolean onStepped(Player player, Direction direction, double power) {
        //System.out.println(String.format("\tHole onStepped(player, %s)", direction));
        if (!super.onStepped(player, direction, power))
            return false;
        else {
            if (isOpen) {
                player.die();
                gameElement = null;
            }
            return true;
        }
    }

    //TODO: fix this

    /**
     * This method is called when a Box steps
     * on it. If the hole is open it destroys the
     * box and decreases the games movableBox count by one.
     * If it is closed it calls the Fields
     * onStepped(player, direction) method and returns
     * its value.
     */
    @Override
    public boolean onStepped(Box box, Direction direction, double power) {
        //System.out.println(String.format("\tHole onStepped(box, %s)", direction));
        if (!super.onStepped(box, direction, power))
            return false;
        else {
            if (isOpen) {
                box.die();
                gameElement = null;
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
        if(isOpen)
            return "Hole";
        else{
            String name="";
        if(hasElement()){
            name=name.concat(gameElement.toString().concat("On"));
        }
        name=name.concat("Field");          //itt csalunk
        if(getStickiness()<1)
            name=name.concat("WithOil");
        if(getStickiness()>1)
            name=name.concat("WithHoney");
        return name;
    }}
}
