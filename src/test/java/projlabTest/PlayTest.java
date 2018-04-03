package projlabTest;

import org.junit.Before;
import org.junit.Test;
import projlab.Direction;
import projlab.Game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayTest {

    Game game;

    @Before
    public void setUp() throws Exception {
        game = Game.getInstance();
    }

    @Test
    public void pushSingleBox() {
        game.startGame("maps/unitTest/pushTest.txt");
        assertTrue(game.movePlayer(Direction.RIGHT));
    }

    @Test
    public void pushMultipleBox() {
        game.startGame("maps/unitTest/pushMultipleBox.txt");
        System.out.println("1 Box");
        assertTrue(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("2 Box");
        assertTrue(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("3 Box");
        assertTrue(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("4 Box");
        assertTrue(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("5 Box");
        assertTrue(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("6 Box");
        game.movePlayer(Direction.RIGHT);
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("7 Box");
        assertFalse(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
        System.out.println("8 Box");
        assertFalse(game.movePlayer(Direction.RIGHT));
        game.movePlayer(Direction.LEFT);
        game.movePlayer(Direction.UP);
    }

    @Test
    public void playerPushPlayer() {
        game.startGame("maps/unitTest/playerPushPlayer.txt");
        for (int i = 0; i < 5; i++){
            assertFalse(game.movePlayer(Direction.RIGHT));
        }

        for (int i = 0; i < 5; i++){
            assertFalse(game.movePlayer(Direction.LEFT));
        }
    }


}
