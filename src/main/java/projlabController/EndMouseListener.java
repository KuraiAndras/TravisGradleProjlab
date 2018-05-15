package projlabController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <h1>EndMouseListener</h1>
 * This class implements MouseListner,
 * and do things if we click
 * on the play button on the GUI.
 */
public class EndMouseListener implements MouseListener {
    /**
     *Click on the right GUI element will call this method.
     * This method calls mainController's switchToMain method.
     * And ovveride MousListener interface mouseClicked method.
     * @param e The sender mouseEvent's.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MainController.getInstance().switchToMain();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
