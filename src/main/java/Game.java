import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//TODO: Add Javadoc
public class Game {
    private HashMap<UUID, Integer> playerScore;
    private UUID currentTurn;
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

    public void onPlayerDead(UUID ID) {
        playerScore.remove(ID);
        if (playerScore.size() == 1) {
            onGameEnd();
        }
    }

    public void incrementScore() {
        playerScore.put(currentTurn, playerScore.get(currentTurn) + 1);
    }

    public int getMovableBox(){
        return movableBox;
    }

    public boolean registerPlayer(UUID ID) {
        if (playerScore.containsKey(ID)) {
            return false;
        } else {
            if (currentTurn == null) {
                currentTurn = ID;
            }
            playerScore.put(ID, 0);
            return true;
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

    public void doLockManagement(){
        map.lockManagement();
    }

    //TODO: Delete logging
    private void startGame(String file) {
        map = new WareHouse();
        map.generateMap(file);
        stepsLeft = 5;
        System.out.println("Map is Generated");
        System.out.println("Number of players: " + playerScore.size());
        System.out.println("Movable boxes: " + movableBox);
        System.out.println("Current players:");
        for (Map.Entry<UUID, Integer> item :
                playerScore.entrySet()) {
            UUID key = item.getKey();
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
