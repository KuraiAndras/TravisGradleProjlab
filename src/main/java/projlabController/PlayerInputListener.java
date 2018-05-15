package projlabController;

import projabModel.Direction;
import projabModel.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <h1>PlayInputListener</h1>
 * This class implements KeyListener,
 * and do things if we press
 * buttons through the game.
 */

public class PlayerInputListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     *This method moves the current player characther if
     * he pressed the right key.
     * W:move up.
     * A:move left.
     * S:move down.
     * D:move right.
     * And ovveride KeyLIstener interface keyPressed method.
     * @param e Key pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                Game.getInstance().movePlayer(Direction.UP);
                break;
            case KeyEvent.VK_A:
                Game.getInstance().movePlayer(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                Game.getInstance().movePlayer(Direction.RIGHT);
                break;
            case KeyEvent.VK_S:
                Game.getInstance().movePlayer(Direction.DOWN);
                break;
            case KeyEvent.VK_Q:
                Game.getInstance().placeHoney();
                break;
            case KeyEvent.VK_E:
                Game.getInstance().placeOil();
                break;
            default:
                break;
        }
        if (!MainController.getInstance().endFlag)
            MainController.getInstance().redrawPlayField();
        else
            MainController.getInstance().callEndView();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
