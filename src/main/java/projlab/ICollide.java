package projlab;

//TODO: Add Javadoc
public interface ICollide {
    boolean collide(Player player, Direction direction, int power);

    boolean collide(Box box, Direction direction, int power);
}
