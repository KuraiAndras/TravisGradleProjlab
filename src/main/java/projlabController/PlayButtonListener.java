package projlabController;

import projabModel.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonListener implements ActionListener {
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
