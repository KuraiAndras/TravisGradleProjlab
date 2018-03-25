package projlab;

//TODO: Add Javadoc
public interface ICollide {
    boolean collide(Player player, Direction direction, double power);

    boolean collide(Box box, Direction direction, double power);
}
