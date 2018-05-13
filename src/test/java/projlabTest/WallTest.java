package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projabModel.Direction;
import projabModel.Field;
import projabModel.Game;
import projabModel.Wall;

import static org.junit.Assert.assertFalse;

public class WallTest {
    private Wall wall;
    private Game game = Game.getInstance();


    @Before
    public void setUp() throws Exception{
        Field field = new Field();
        wall = new Wall(field);
        field.setGameElement(wall);
        game.loadGame("maps/wallTest.txt");
    }

    @Test
    public void collidePlayer() {
        assertFalse(game.movePlayer(Direction.DOWN));
    }

    @Test
    public void collideBox() {
        assertFalse(game.movePlayer(Direction.RIGHT));
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