package projlabTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projlab.*;

public class WallTest {
    private Wall wall;
    private Game game = Game.getInstance();


    @Before
    public void setUp() {
        Field field = new Field();
        wall = new Wall(field);
        field.setGameElement(wall);
        game.startGame("maps/wallTest.txt");
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