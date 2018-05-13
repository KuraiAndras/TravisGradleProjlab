package projabModel;

import projlabController.MainController;

import java.util.ArrayList;
import java.util.Collections;
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
    private LinkedHashSet<Player> initialPlayerList = new LinkedHashSet<>();

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
        MainController.getInstance().endGame();
    }

    void onPlayerDead(Player player) {
//        playerScore.remove(player);
        playerList.remove(player);
        cyclicIterator.remove(player, currentTurn);
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
        initialPlayerList.add(player);
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
        if (playerList.size() == 1) {
            onGameEnd();
        }
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
        initialPlayerList = new LinkedHashSet<>();
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

    public int getStepsLeft() {
        return stepsLeft;
    }

    public int getMovableBoxes() {
        return movableBox;
    }

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

    public ArrayList<Integer> getPointList() {
        ArrayList<Integer> pointList = new ArrayList<>();
        for (Player item : initialPlayerList) {
            pointList.add((playerScore.get(item)));
        }
        return pointList;
    }
}

