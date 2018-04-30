package projlabController;

import projabModel.Game;
import projlabView.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMouseListener implements ActionListener {
    private Game game = Game.getInstance();
    private MainMenu parent;

    public PlayMouseListener(MainMenu main) {
        parent = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.loadGame("maps/playableMaps/" + parent.getCurrentMap() + ".txt");
    }
}
