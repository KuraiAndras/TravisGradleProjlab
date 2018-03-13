import java.util.UUID;
import static org.junit.Assert.assertFalse;

public class WallTest {

    private Field field00;
    private Field field01;
    private Field field02;
    private Field field10;
    private Field field11;
    private Field field12;
    private Wall wallPlayer;
    private Wall wallBox;
    private Box box;
    private Player player;

    @org.junit.Before
    public void setUp() throws Exception {
        field00 = new Field();
        field01 = new Field();
        field02 = new Field();
        field10 = new Field();
        field11 = new Field();
        field12 = new Field();

        field00.setNeighbour(null, Direction.UP);
        field00.setNeighbour(field01, Direction.RIGHT);
        field00.setNeighbour(field10, Direction.DOWN);
        field00.setNeighbour(null, Direction.LEFT);
        player = new Player(UUID.randomUUID(),field00);
        field00.setGameElement(player);

        field01.setNeighbour(null, Direction.UP);
        field01.setNeighbour(field02, Direction.RIGHT);
        field01.setNeighbour(field11, Direction.DOWN);
        field01.setNeighbour(field00, Direction.LEFT);
        box = new Box(field01);
        field01.setGameElement(box);

        field02.setNeighbour(null, Direction.UP);
        field02.setNeighbour(null, Direction.RIGHT);
        field02.setNeighbour(field12, Direction.DOWN);
        field02.setNeighbour(field01, Direction.LEFT);
        wallBox = new Wall(field02);
        field02.setGameElement(wallBox);

        field10.setNeighbour(field00, Direction.UP);
        field10.setNeighbour(field11, Direction.RIGHT);
        field10.setNeighbour(null, Direction.DOWN);
        field10.setNeighbour(null, Direction.LEFT);
        wallPlayer = new Wall(field10);
        field10.setGameElement(wallPlayer);

        field11.setNeighbour(field01, Direction.UP);
        field11.setNeighbour(field12, Direction.RIGHT);
        field11.setNeighbour(null, Direction.DOWN);
        field11.setNeighbour(field10, Direction.LEFT);

        field12.setNeighbour(field02, Direction.UP);
        field12.setNeighbour(null, Direction.RIGHT);
        field12.setNeighbour(null, Direction.DOWN);
        field12.setNeighbour(field11, Direction.LEFT);
    }

    @org.junit.Test
    public void collidePlayer() {
        assertFalse(player.move(Direction.DOWN));
    }

    @org.junit.Test
    public void collideBox() {
        assertFalse(player.move(Direction.RIGHT));
    }

    @org.junit.Test
    public void getCanMove() {
        assertFalse(wallBox.getCanMove());
        assertFalse(wallPlayer.getCanMove());
    }

    @org.junit.Test
    public void lockRequest() {
        wallBox.lockRequest();
        wallBox.getCanMove();
    }
}