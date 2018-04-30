package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMouseListener implements ActionListener {
    Game game = Game.getInstance();
    private MainMenu parent;

    PlayMouseListener(MainMenu main) {
        parent = main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.loadGame("maps/playableMaps/" + parent.getCurrentMap() + ".txt");
    }
}
