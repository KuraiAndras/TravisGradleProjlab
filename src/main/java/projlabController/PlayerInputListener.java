package projlabController;

import projabModel.Direction;
import projabModel.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInputListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            Game.getInstance().movePlayer(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            Game.getInstance().movePlayer(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            Game.getInstance().movePlayer(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            Game.getInstance().movePlayer(Direction.DOWN);
        }
        MainController.getInstance().redrawPlayField();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
