package projlab;

import java.util.*;

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

    private Game() {
        //TODO: Implement this
        map = new WareHouse();
        playerScore = new HashMap<>();
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
    }

    public static Game getInstance() {
        return ourInstance;
    }

    public static void main(String[] args) {
        //Test map for the lockManagement method
        Game game = Game.getInstance();
        ProtoTest pt = new ProtoTest();
        pt.runTestMenu(game);
    }

    private void onGameEnd() {
        //TODO: Implement this
    }

    public void onPlayerDead(Player player) {
        playerScore.remove(player);
        if (playerScore.size() == 1) {
            onGameEnd();
        }
        if (player == currentTurn) {
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps;
        }
    }

    public void incrementScore() {
        playerScore.put(currentTurn, playerScore.get(currentTurn) + 1);
    }

    public int getMovableBox() {
        return movableBox;
    }

    public void registerPlayer(Player player) {
        playerList.add(player);
        playerScore.put(player, 0);

        if (currentTurn == null) {
            currentTurn = player;
        }
    }

    public void registerBox() {
        movableBox++;
    }

    public void decreaseMovableBox() {
        movableBox--;
        if (movableBox == 0) {
            onGameEnd();
        }
    }

    //this method is only used during development
    public void doLockManagement() {
        map.lockManagement();
    }

    private void logGame() {
        map.logMap();
        System.out.println("Map is Generated");
        System.out.println("Number of players: " + playerScore.size());
        System.out.println("Movable boxes: " + movableBox);
        System.out.println("Current players:");
        for (Map.Entry<Player, Integer> item :
                playerScore.entrySet()) {
            Player key = item.getKey();
            Integer value = item.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println("Current turn: " + currentTurn);
        System.out.println("Total steps: " + totalSteps);
        System.out.println("Steps left: " + stepsLeft);
        System.out.print("\n");
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
       // logGame();
    }

    public boolean checkPlayerCompression(Player examining) {
        if (currentTurn != examining) {
            examining.die();
            return true;
        } else
            return false;
    }

    public boolean checkPlayerVitality(Player examining) {
        return currentTurn == examining;
    }

    //TODO: Delete logging
    //Should we make it private? Only tests need public visibility
    public void startGame(String file) {
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
        //logGame();
    }

    public ArrayList<ArrayList<Field>> getMap() {
        return map.getMap();
    }
}

