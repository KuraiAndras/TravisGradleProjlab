package projabModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

//TODO: Add Javadoc
public class Game {
    private static Game ourInstance = new Game();
    private HashMap<Player, Integer> playerScore;
    private Player currentTurn;
    private int totalSteps;
    private int stepsLeft;
    private int movableBox;
    private WareHouse map;
    private LinkedHashSet<Player> playerList;
    private CyclicIterator<Player, LinkedHashSet<Player>> cyclicIterator;
    //private static String clearConsole = "\033[H\033[2J";
    //private static String partialMapPath = "maps/playableMaps";

    private Game() {
        map = new WareHouse();
        playerScore = new HashMap<>();
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
    }

    public static Game getInstance() {
        return ourInstance;
    }

    private void onGameEnd() {
        //TODO: Implement this
    }

    void onPlayerDead(Player player) {
        playerScore.remove(player);
        if (playerScore.size() == 1) {
            onGameEnd();
        }
        if (player == currentTurn) {
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps;
        }
    }

    void incrementScore() {
        playerScore.put(currentTurn, playerScore.get(currentTurn) + 1);
    }

    int getMovableBox() {
        return movableBox;
    }

    void registerPlayer(Player player) {
        playerList.add(player);
        playerScore.put(player, 0);

        if (currentTurn == null) {
            currentTurn = player;
        }
    }


    void registerBox() {
        movableBox++;
    }

    void decreaseMovableBox() {
        movableBox--;
        if (movableBox == 0) {
            onGameEnd();
        }
    }

    //this method is only used during development
    void doLockManagement() {
        map.lockManagement();
    }

    public boolean movePlayer(Direction direction) {
        boolean lastMove = currentTurn.move(direction);
        decreaseSteps();
        return lastMove;
    }

    public boolean placeHoney() {
        if (currentTurn.placeSticky(2)) {
            decreaseSteps();
            return true;
        } else {
            return false;
        }
    }

    public boolean placeOil() {
        if (currentTurn.placeSticky(0.5)) {
            decreaseSteps();
            return true;
        } else {
            return false;
        }
    }

    private void decreaseSteps() {
        stepsLeft--;
        if (stepsLeft == 0) {
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps;
        }
    }

    boolean checkPlayerCompression(Player examining) {
        if (currentTurn != examining) {
            examining.die();
            return true;
        } else
            return false;
    }

    boolean checkPlayerVitality(Player examining) {
        return currentTurn == examining;
    }

    //TODO: Delete logging
    //Should we make it private? Only tests need public visibility
    public void loadGame(String file) {
        playerScore = new HashMap<>();
        currentTurn = null;
        movableBox = 0;
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
        map = new WareHouse();
        map = map.generateMap(file);
        if (map == null) {
            System.err.println("Map Generation Failed");
            return;
        }
        if (!playerList.isEmpty()) {
            cyclicIterator.next();
        }
        stepsLeft = 5;
        totalSteps = 5;
    }

    public ArrayList<ArrayList<Field>> getMap() {
        return map.getMap();
    }
}

