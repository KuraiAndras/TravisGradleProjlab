package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projlab.*;

import static org.junit.Assert.*;

public class BoxTest {
    private Box box;
    private Game game = Game.getInstance();

    @Before
    public void setUp() throws Exception {
        Field field = new Field();
        box = new Box(field) ;
        field.setGameElement(box);
        game.startGame("maps/wallTest.txt");

    }

    @Test
    public void lockRequest() {
        box.lockRequest();
        assertFalse(box.getCanMove());
    }

    @Test
    public void getCanMove() {
        assertTrue(box.getCanMove());
    }

    @Test
    public void move() {
        assertTrue(game.movePlayer(Direction.UP));              //player altal mozog, player tolja
        assertTrue(game.movePlayer(Direction.RIGHT));
        assertTrue(game.movePlayer(Direction.DOWN));
        assertFalse(game.movePlayer(Direction.DOWN));
    }

    @Test
    public void collideplayer() {
        assertTrue(game.movePlayer(Direction.UP));              //player által mozog, ugyanaz mint a move
        assertTrue(game.movePlayer(Direction.RIGHT));
        assertTrue(game.movePlayer(Direction.DOWN));
        assertFalse(game.movePlayer(Direction.DOWN));
    }

    @Test
    public void collide1box() {
        assertTrue(game.movePlayer(Direction.UP));              //mivel eltol egy másik ládát ezért nincs új történés, move-hoz hasonló
        assertTrue(game.movePlayer(Direction.RIGHT));
        assertTrue(game.movePlayer(Direction.DOWN));
        assertFalse(game.movePlayer(Direction.DOWN));
    }

}
