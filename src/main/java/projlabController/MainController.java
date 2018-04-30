package projlabController;

import projabModel.Game;
import projlabView.MainMenu;

public class MainController {
    private Game game = Game.getInstance();
    private MainMenu mainMenu;

    void initializeComponents(){
        mainMenu = new MainMenu();
    }
}
