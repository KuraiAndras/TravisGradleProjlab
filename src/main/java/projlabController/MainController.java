package projlabController;

import projabModel.Game;
import projlabView.GameWindow;
import projlabView.MainMenu;

public class MainController {
    private Game game = Game.getInstance();
    private MainMenu mainMenu;
    private GameWindow gameWindow;

    private static MainController ourInstance = new MainController();

    public static MainController getInstance() {
        return ourInstance;
    }

    void initializeComponents() {
        mainMenu = new MainMenu();
        gameWindow = new GameWindow();
    }

    void startGame() {
        mainMenu.setVisible(false);
        gameWindow.setVisible(true);
        gameWindow.load();
    }

    public void endGame(){
        gameWindow.setEndFlag();
    }

    String getCurrentMap() {
        return mainMenu.getCurrentMap();
    }

    void redrawPlayField() {
        gameWindow.drawElements();
    }
}
