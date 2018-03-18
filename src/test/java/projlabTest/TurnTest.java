package projlabTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projlab.*;

public class TurnTest {
    private  Game game;


    @Before
    public void setUp() throws Exception {
        game = Game.getInstance();
        game.startGame("maps/iterationTest");
    }

    @Test
    public void iterationTest() {
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertFalse(game.movePlayer(Direction.UP));

        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertTrue(game.movePlayer(Direction.UP));
        assertFalse(game.movePlayer(Direction.UP));


    }
}
