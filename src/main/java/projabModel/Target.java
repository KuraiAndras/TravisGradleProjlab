package projabModel;

/**
 * <h1>Target</h1>
 * This is a special Field object.
 * Every target locks the first box
 * that moves to it.
 */
public class Target extends Field {

    /**
     * This method collides the currently stored object
     * with the box trying to step on it. If the currently
     * stored object is null or it could be moved then it
     * locks the box and increases the active players score.
     * If the stored object couldn't move then it returns false.
     *
     * @param box       The box stepping on the field.
     * @param direction The direction of the box
     * @return Returns true if the box stepped on it, else returns false.
     */
    @Override
    public boolean onStepped(Box box, Direction direction, double power) {
        //  System.out.println("\tTarget onStepped(box, direction)");
        if (gameElement == null) {
            gameElement = box;
            Game.getInstance().incrementScore();
            box.lockRequest();
            return true;
        }
        if (gameElement.collide(box, direction, power)) {
            gameElement = box;
            Game.getInstance().incrementScore();
            box.lockRequest();
            return true;
        } else {
            return false;
        }
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
        name=name.concat("Target");
        if(getStickiness()<1)
            name=name.concat("WithOil");
        if(getStickiness()>1)
            name=name.concat("WithHoney");
        return name;
    }
}
