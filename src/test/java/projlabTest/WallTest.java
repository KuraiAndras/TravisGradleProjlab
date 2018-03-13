package projlabTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projlab.*;

public class WallTest {
    private Player player;
    private Wall wall;


    @Before
    public void setUp() {
        Field field = new Field();
        wall = new Wall(field);
        field.setGameElement(wall);

        FakeWarehouse fakeWarehouse = new FakeWarehouse();
        player = fakeWarehouse.generateTestMapPlayer("maps/wallTest.txt");
    }

    @Test
    public void collidePlayer() {
        assertFalse(player.move(Direction.DOWN));
    }

    @Test
    public void collideBox() {
        assertFalse(player.move(Direction.RIGHT));
    }

    @Test
    public void getCanMove() {
        assertFalse(wall.getCanMove());
    }

    @Test
    public void lockRequest() {
        wall.lockRequest();
        assertFalse(wall.getCanMove());
        wall.lockRequest();
        assertFalse(wall.getCanMove());
    }
}