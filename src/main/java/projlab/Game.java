package projlab;

import java.util.HashMap;
import java.util.Map;

//TODO: Add Javadoc
public class Game {
    private HashMap<Player, Integer> playerScore;
    private Player currentTurn;
    private int stepsLeft;
    private int movableBox;
    private WareHouse map;


    private static Game ourInstance = new Game();

    public static Game getInstance() {
        return ourInstance;
    }

    private Game() {
        //TODO: Implement this
        map = new WareHouse();
        playerScore = new HashMap<>();
    }

    private void onGameEnd() {
        //TODO: Implement this
    }

    public void onPlayerDead(Player player) {
        playerScore.remove(player);
        if (playerScore.size() == 1) {
            onGameEnd();
        }
    }

    public void incrementScore() {
        playerScore.put(currentTurn, playerScore.get(currentTurn) + 1);
    }

    public int getMovableBox() {
        return movableBox;
    }

    public void registerPlayer(Player player) {
        if (currentTurn == null) {
            currentTurn = player;
        }
        playerScore.put(player, 0);
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

    //this method is only used during development?
    public void doLockManagement() {
        map.lockManagement();
    }

    public boolean movePlayer(Direction direction){
        boolean lastMove;
        lastMove = currentTurn.move(direction);
        stepsLeft--;
        if(stepsLeft == 0){
            //TODO: Iterate through players
        }
        return lastMove;
    }

    //TODO: Delete logging
    //Should we make it private? Only tests need public visibility
    public void startGame(String file) {
        playerScore = new HashMap<>();
        currentTurn = null;
        movableBox = 0;
        map = new WareHouse();
        map = map.generateMap(file);
        if (map == null) {
            System.err.println("Map Generation Failed");
            return;
        }
        stepsLeft = 5;
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
        System.out.println("Steps left: " + stepsLeft);
    }

    public static void main(String[] args) {
        //Test map for the lockManagement method
        Game game = Game.getInstance();
        game.startGame("maps/map_lock_management_test.txt");
        game.doLockManagement();
    }
}
