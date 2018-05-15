package projabModel;

/**
 * <h1>IStep</h1>
 * Interface for things a GameObject can step to.
 */
public interface IStep {

    /**
     * The things which would happen if a player step that direction.
     * @param player Player who stepped.
     * @param direction The direction the player stepped.
     * @param power The power which went through step.
     * @return The step was succesfull or failed.
     */
    boolean onStepped(Player player, Direction direction, double power);

    /**
     * The things which would happen if a box step that direction.
     * @param box Box who stepped.
     * @param direction The direction the player stepped.
     * @param power The power which went through step.
     * @return The step was succesfull or failed.
     */
    boolean onStepped(Box box, Direction direction, double power);

    /**
     * This method returns the next field in the given direction.
     *
     * @param player    The player standing on the field.
     * @param direction The direction of the players next step.
     * @return Returns with the field in the given direction.
     */
    Field offStepped(Player player, Direction direction);

    /**
     * This method returns the next field in the given direction.
     *
     * @param box       The box being on the field.
     * @param direction The direction of the boxes next step.
     * @return Returns with the field in the given direction.
     */
    Field offStepped(Box box, Direction direction);
}
