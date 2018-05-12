package projlabController;

import projabModel.Game;
import projlabView.GameWindow;
import projlabView.MainMenu;

public class MainController {
    private Game game = Game.getInstance();
    private MainMenu mainMenu;
    GameWindow gameWindow;
    boolean endFlag = false;

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

    public void endGame() {
        endFlag = true;
    }

    String getCurrentMap() {
        return mainMenu.getCurrentMap();
    }

    void redrawPlayField() {
        gameWindow.drawElements();
    }

    void switchToMain(){
        mainMenu.setVisible(true);
        gameWindow = new GameWindow();
        gameWindow.setVisible(false);
        endFlag = false;
    }
}
