package projabModel;


/**
 * <h1>ICollide</h1>
 * This is an interface for gameElements
 * which can collide with each other.
 */
public interface ICollide {
    /**
     *This method collides the player with a gameElemnt.
     * @param player Player who started the collide.
     * @param direction Direction the player collided.
     * @param power Power which went through during the collide.
     * @return The collide was succesfull or failed.
     */
    boolean collide(Player player, Direction direction, double power);

    /**
     *This method collides a box with a gameElemnt.
     * @param box Box who started the collide.
     * @param direction Direction the box collided.
     * @param power Power which went through during the collide.
     * @return The collide was succesfull or failed.
     */
    boolean collide(Box box, Direction direction, double power);
}
