package projabModel;

/**
 * <h1>IPlayable</h1>
 * This is an interface for players which
 * contains the orders te players can make.
 */
public interface IPlayable {
    /**
     * This method moves the player to the given direction.
     * @param direction Direction the player would like to go.
     * @return The movement was succesfull or failed.
     */
    boolean move(Direction direction);

    /**
     *With this method players can set their owner fields stickiness.
     * @param stickiness Amount of stickiness the player would like to
     * increase or decrease the owner stickiness.
     * @return The placing stickiness was succesfull or failed.
     */
    boolean placeSticky(double stickiness);
}
