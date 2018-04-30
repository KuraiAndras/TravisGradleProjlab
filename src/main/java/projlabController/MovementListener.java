package projlabController;

import projabModel.Direction;
import projabModel.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            Game.getInstance().movePlayer(Direction.UP);
            System.out.println("W");
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            Game.getInstance().movePlayer(Direction.LEFT);
            System.out.println("A");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            Game.getInstance().movePlayer(Direction.RIGHT);
            System.out.println("D");
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            Game.getInstance().movePlayer(Direction.DOWN);
            System.out.println("S");
        }
        MainController.getInstance().redrawPlayField();
    }
}
