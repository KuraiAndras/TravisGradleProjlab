package projlabController;

import projabModel.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.getInstance().loadGame("maps/playableMaps/" + MainController.getInstance().getCurrentMap() + ".txt");
        MainController.getInstance().startGame();
    }
}
