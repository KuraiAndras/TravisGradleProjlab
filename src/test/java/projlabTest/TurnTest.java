package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projlab.Direction;
import projlab.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TurnTest {
    private Game game;


    @Before
    public void setUp() throws Exception {
        game = Game.getInstance();
        game.loadGame("maps/iterationTest");
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
