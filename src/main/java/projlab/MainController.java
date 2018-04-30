package projlab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private Game game = Game.getInstance();
    private MainMenu mainMenu;

    void initializeComponents(){
        mainMenu = new MainMenu();
    }
}
