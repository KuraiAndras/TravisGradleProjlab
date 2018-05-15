package projlabController;

import projlabView.GameWindow;
import projlabView.MainMenu;

/**
 * <h1>MainController</h1>
 * This class is responsible to control GUI.
 */


public class MainController {
    /**
     * The game's main menu.
     */
    private MainMenu mainMenu;
    /**
     * The game's window.
     */
    private GameWindow gameWindow;
    /**
     * A flag for the game state.
     */
    boolean endFlag = false;

    /**
     * The MainController's only object.
     */
    private static MainController ourInstance = new MainController();

    /**
     *This method gives the MainController onyl object back.
     * @return MainContrller only object.
     */
    public static MainController getInstance() {
        return ourInstance;
    }

    /**
     * This method intialize the GUI's components.
     */
    void initializeComponents() {
        mainMenu = new MainMenu();
        gameWindow = new GameWindow();
    }

    /**
     * This method starts the game.
     * Turn of the main menu,
     * turn on the game window,
     * and call the gameWindow's load method.
     */
    void startGame() {
        mainMenu.setVisible(false);
        gameWindow.setVisible(true);
        gameWindow.load();
    }

    /**
     * This method ends the game.
     */
    public void endGame() {
        endFlag = true;
    }

    /**
     * This method returns the current map
     * where the players are playing.
     * @return Returns the current map.
     */
    String getCurrentMap() {
        return mainMenu.getCurrentMap();
    }

    /**
     * This method calls gameWindow's drawelements method.
     */
    void redrawPlayField() {
        gameWindow.drawElements();
    }

    /**
     * This method switches back to the game main menu.
     */
    void switchToMain(){
        mainMenu.setVisible(true);
        gameWindow.setVisible(false);
        gameWindow = new GameWindow();
        endFlag = false;
        mainMenu.updateErrorMessage("");
    }

    /**
     * This method passes the error message that it got
     * to mainMenu's updateErrorMessage method.
     * @param message An error message in String format.
     */
    void errorHappened(String message){
        mainMenu.updateErrorMessage(message);
    }

    /**
     * This method calls gameWindow's endView method.
     */
    void callEndView(){
        gameWindow.endView();
    }
}
