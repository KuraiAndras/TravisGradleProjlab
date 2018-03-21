package projlab;

//TODO: Add Javadoc
public interface IStep {
    boolean onStepped(Player player, Direction direction, int power);

    boolean onStepped(Box box, Direction direction, int power);

    Field offStepped(Player player, Direction direction);

    Field offStepped(Box box, Direction direction);
}
