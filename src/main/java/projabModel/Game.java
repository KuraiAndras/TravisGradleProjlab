package projabModel;

import projlabController.MainController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * <h1>Game</h1>
 * This class  is responsible for the players can play the game.
 * Stores important informations about the game , the current state of the game.
 */
public class Game {
    /**
     * Only game object.
     */
    private static Game ourInstance = new Game();
    /**
     * Store players and their points.
     */
    private HashMap<Player, Integer> playerScore;
    /**
     * The currently playing player.
     */
    private Player currentTurn;
    /**
     *Every player start their turn with the number of totalSteps.
     */
    private int totalSteps;
    /**
     *Every step that the player made their step is decreased.
     */
    private int stepsLeft;
    /**
     * Number of boexes that can be moved by players on the map.
     */
    private int movableBox;
    /**
     *Players play on a warehouse map.
     */
    private WareHouse map;
    /**
     * List of players who are alive.
     */
    private LinkedHashSet<Player> playerList;
    /**
     * Iterator which iterate through players.
     */
    private CyclicIterator<Player, LinkedHashSet<Player>> cyclicIterator;
    /**
     * List of players who started to play the game.
     */
    private LinkedHashSet<Player> initialPlayerList = new LinkedHashSet<>();

    /**
     * Private default constructor ,which
     * Set up a new warehouse map,
     * a new hashmap for players' score,
     * and an cycliciterator.
     */
    private Game() {
        map = new WareHouse();
        playerScore = new HashMap<>();
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
    }

    /**
     * This method gives back our only game object.
     * @return our only game object.
     */
    public static Game getInstance() {
        return ourInstance;
    }

    /**
     * Calls our only gamecontroller object's endGame method.
     */
    private void onGameEnd() {
        MainController.getInstance().endGame();
    }

    /**
     * Removes the player from everywhere,
     * if the currently playing player died,
     * his/her turn will end.
     * The game will call the onGameEnd method,
     * if onyl one player is alive.
     * @param player Player who died.
     */
    void onPlayerDead(Player player) {
//        playerScore.remove(player);
        if (player == currentTurn) {
            playerList.remove(player);
            cyclicIterator.remove(player, currentTurn);
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps + 1;
        } else {
            playerList.remove(player);
            cyclicIterator.remove(player, currentTurn);
        }
        if (playerScore.size() == 1) {
            onGameEnd();
        }
    }

    /**
     * Increment the currently playing player score by 1
     * if he/her push a box on a target.
     */
    void incrementScore() {
        playerScore.put(currentTurn, playerScore.get(currentTurn) + 1);
    }

    /**
     * This method gives the movable boxes amount back .
     * @return The movabeleBoxes number on the map.
     */
    int getMovableBox() {
        return movableBox;
    }

    /**
     * The method register the given player into playerList,
     *playerScore and initialPlayerList.
     * @param player Plyar we would like to register into our game.
     */
    void registerPlayer(Player player) {
        playerList.add(player);
        playerScore.put(player, 0);
        initialPlayerList.add(player);
        if (currentTurn == null) {
            currentTurn = player;
        }
    }

    /**
     * Add a movable box to the movableBoxes.
     */
    void registerBox() {
        movableBox++;
    }

    /**
     * Decrease the movable box(es) number,
     * if it is 0, it will call the onGameEnd method.
     */
    void decreaseMovableBox() {
        movableBox--;
        if (movableBox == 0) {
            onGameEnd();
        }
    }

    //this method is only used during development

    /**
     * Calls the map lockManagement method.
     */
    void doLockManagement() {
        map.lockManagement();
    }

    /**
     *This method tries to move the current player to the given direction,
     * and decrease his/her step.
     * @param direction Direction the player would like to step.
     * @return Player move was succesful or failed.
     */
    public boolean movePlayer(Direction direction) {
        boolean lastMove = currentTurn.move(direction);
        decreaseSteps();
        if (playerList.size() == 1) {
            onGameEnd();
        }
        return lastMove;
    }

    /**
     * The currently playing player place honey
     * on the field where he/she is standing,
     * and decrease his/her steps,
     * and increase the field stickyness.
     * @return PlaceHoneney was succesfull or failed.
     */
    public boolean placeHoney() {
        if (currentTurn.placeSticky(2)) {
            decreaseSteps();
            return true;
        } else {
            return false;
        }
    }
    /**
     * The currently playing player place oil
     * on the field where he/she is standing,
     * and decrease his/her steps,
     * and deccresae the field stickyness.
     * @return PlaceHoneney was succesfull or failed.
     */
    public boolean placeOil() {
        if (currentTurn.placeSticky(0.5)) {
            decreaseSteps();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Decrease the the current player's step.
     * If it is 0 the next player will start his/her turn.
     */
    private void decreaseSteps() {
        stepsLeft--;
        if (stepsLeft == 0) {
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps;
        }
    }

    /**
     *If the current player kill an other player,
     * this method kills the other player.
     * @param examining Player whose death we would like to examine.
     * @return The examined player died or not.
     */
    boolean checkPlayerCompression(Player examining) {
        if (currentTurn != examining) {
            examining.die();
            return true;
        } else
            return false;
    }

    /**
     * This method checkes player vitality.
     * @param examining The given player.
     * @return The given player is currently playing or not.
     */
    boolean checkPlayerVitality(Player examining) {
        return currentTurn == examining;
    }

    //TODO: Delete logging
    //Should we make it private? Only tests need public visibility

    /**
     * Load the map from the given file path and inicialize the objects on the map.
     * @param file String file path where the game will be loaded.
     * @throws Exception Exception if the warehouse map is not surrounded with walls.
     */
    public void loadGame(String file) throws Exception {
        playerScore = new HashMap<>();
        currentTurn = null;
        movableBox = 0;
        playerList = new LinkedHashSet<>();
        initialPlayerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
        map = new WareHouse();
        map = map.generateMap(file);
        if (!playerList.isEmpty()) {
            cyclicIterator.next();
        }
        stepsLeft = 5;
        totalSteps = 5;
    }

    /**
     *This method returns the currently played map.
     * @return The map's fields in ArrayList format.
     */
    public ArrayList<ArrayList<Field>> getMap() {
        return map.getMap();
    }

    /**
     * This method returns the who many steps the player has.
     * @return The current amount step left
     * from the currently playing player.
     */
    public int getStepsLeft() {
        return stepsLeft;
    }

    /**
     * This method return the movable boxes amount.
     * @return The current amount moavble boxes left
     * from the currently played warehouse map.
     */
    public int getMovableBoxes() {
        return movableBox;
    }

    /**
     * This method gives the winner player back.
     * @return The player number who won the game.
     */
    public int getWinner() {
        int i = 1;
        int winner = 0;

        if (playerList.size() == 1) {
            for (Player item : initialPlayerList) {
                if (playerList.contains(item)) {
                    winner = i;
                    return winner;
                }
                i++;
            }
        }

        i = 1;
        winner = 0;

        ArrayList<Integer> pointList = getPointList();
        for (Player item : initialPlayerList) {
            if (playerScore.get(item).equals(Collections.max(pointList))) {
                winner = i;
            }
            i++;
        }
        return winner;
    }

    /**
     * This method stores the player points.
     * @return An arraylist which stores each player points.
     */
    public ArrayList<Integer> getPointList() {
        ArrayList<Integer> pointList = new ArrayList<>();
        for (Player item : initialPlayerList) {
            pointList.add((playerScore.get(item)));
        }
        return pointList;
    }
}

