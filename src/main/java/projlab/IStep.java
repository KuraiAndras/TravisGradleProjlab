package projlab;

/**
 * Interface for things a GameObject can step to.
 */
public interface IStep {

    boolean onStepped(Player player, Direction direction, double power);

    boolean onStepped(Box box, Direction direction, double power);

    /**
     * This method returns the next field in the given direction.
     *
     * @param player The player standing on the field.
     * @param direction The direction of the players next step.
     * @return Returns with the field in the given direction.
     */
    Field offStepped(Player player, Direction direction);

    /**
     * This method returns the next field in the given direction.
     *
     * @param box The box being on the field.
     * @param direction The direction of the boxes next step.
     * @return Returns with the field in the given direction.
     */
    Field offStepped(Box box, Direction direction);
}
