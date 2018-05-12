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
            MainController.getInstance().gameWindow.endView();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
