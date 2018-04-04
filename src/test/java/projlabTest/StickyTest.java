package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projlab.Direction;
import projlab.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StickyTest {
    private Game game = Game.getInstance();

    @Before
    public void setUp() {
        game.loadGame("maps/stickyTest");
    }

    @Test
    public void testPlaceHoney() {
        assertTrue(game.placeHoney());
    }

    @Test
    public void testPlaceOil() {
        assertTrue(game.placeOil());
    }

    @Test
    public void testReplaceSurface1() {
        assertTrue(game.placeOil());
        assertFalse(game.placeHoney());
    }

    @Test
    public void testReplaceSurface2() {
        assertTrue(game.placeOil());
        assertFalse(game.placeOil());
    }

    @Test
    public void testReplaceSurface3() {
        assertTrue(game.placeHoney());
        assertFalse(game.placeHoney());
    }

    @Test
    public void testReplaceSurface4() {
        assertTrue(game.placeHoney());
        assertFalse(game.placeOil());
    }

    @Test
    public void testHoneyPush() {
        assertFalse(game.movePlayer(Direction.RIGHT));
        game.placeHoney();
        assertTrue(game.movePlayer(Direction.RIGHT));
    }

    @Test
    public void testOilPush() {
        assertFalse(game.movePlayer(Direction.RIGHT));
        game.placeOil();
        assertFalse(game.movePlayer(Direction.RIGHT));
    }
}
