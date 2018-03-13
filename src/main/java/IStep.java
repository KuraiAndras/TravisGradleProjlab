//TODO: Add Javadoc
public interface IStep {
    boolean onStepped(Player player, Direction direction);

    boolean onStepped(Box box, Direction direction);

    Field offStepped(Player player, Direction direction);

    Field offStepped(Box box, Direction direction);
}
