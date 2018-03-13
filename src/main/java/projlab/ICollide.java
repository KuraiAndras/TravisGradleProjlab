package projlab;

//TODO: Add Javadoc
public interface ICollide {
    boolean collide(Player player, Direction direction);

    boolean collide(Box box, Direction direction);
}
