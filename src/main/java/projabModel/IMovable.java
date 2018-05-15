package projabModel;

/**
 * <h1>IMovable</h1>
 * This is an interface for gameElements
 * which can move.
 */
public interface IMovable {
    /**
     * This method will move gameElements.
     * @param direction The Direction the gameElemnt would like to move.
     * @param power Power which will go through during the movement.
     * @return The movement was succesfully or failed.
     */
    boolean move(Direction direction, double power);
}
