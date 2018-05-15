package projlabController;

import projabModel.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h1>EndMouseListener</h1>
 * This class implements ActionListener,
 * and do things if we click
 * on end button on the GUI.
 */
public class PlayButtonListener implements ActionListener {
    /**
     *Click on the right GUI element will call this method.
     * This method starts the map loading process,
     * and handle exceptions.
     * And ovveride ActionlIstener interface actionPerformed method.
     * @param e The sender mouseEvent's.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Game.getInstance().loadGame("maps/playableMaps/" + MainController.getInstance().getCurrentMap() + ".txt");
            MainController.getInstance().startGame();
        } catch (Exception exception){
            MainController.getInstance().errorHappened(exception.getMessage());
        }
    }
}
