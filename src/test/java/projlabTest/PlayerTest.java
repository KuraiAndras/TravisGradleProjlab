package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projlab.*;

import static org.junit.Assert.*;


public class PlayerTest {
    private Player player;
    private Game game = Game.getInstance();

    @Before
    public void setUp() throws Exception {
        Field field = new Field();
        player = new Player(field);
        field.setGameElement(player);

        game.startGame("maps/wallTest.txt");
    }

    @Test
    public void die() {
        //assertFalse(game.movePlayer(Direction.DOWN));
        //TODO: meg kell írni, ha a bug-ok javítva lettek
    }

    @Test
    public void move() {
        assertTrue(game.movePlayer(Direction.UP));
        assertFalse(game.movePlayer(Direction.UP));
    }

    @Test
    public void collidePlayer() {
        assertTrue(game.movePlayer(Direction.LEFT));     //player collides with player
    }

    @Test
    public void collideBox() {                        //player collides with box
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.RIGHT));
        assertTrue(game.movePlayer(Direction.DOWN));
        assertFalse(game.movePlayer(Direction.DOWN));
    }

    @Test
    public void getCanMove() {
        assertTrue(player.getCanMove());
    }

    @Test
    public void lockRequest() {                     //mindenképp tud mozogni
        player.lockRequest();
        assertTrue(player.getCanMove());
    }

}