package projlab;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

//TODO: Add Javadoc
public class Game {
    private HashMap<Player, Integer> playerScore;
    private Player currentTurn;
    private int totalSteps;
    private int stepsLeft;
    private int movableBox;
    private WareHouse map;
    private LinkedHashSet<Player> playerList;
    private CyclicIterator<Player, LinkedHashSet<Player>> cyclicIterator;

    private static Game ourInstance = new Game();

    public static Game getInstance() {
        return ourInstance;
    }

    private Game() {
        //TODO: Implement this
        map = new WareHouse();
        playerScore = new HashMap<>();
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
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

    //this method is only used during development?
    public void doLockManagement() {
        map.lockManagement();
    }

    public void logGame() {
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
        boolean lastMove;
        lastMove = currentTurn.move(direction);
        stepsLeft--;
        if (stepsLeft == 0) {
            currentTurn = cyclicIterator.next();
            stepsLeft = totalSteps;
        }
        logGame();
        return lastMove;
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
        logGame();
    }

    public void displaySkeletonMenu() {
        System.out.flush();
        System.out.println("Welcome to We <3 IIT skeleton");
        System.out.println("1: P F ");
        System.out.println("2: P B F ");
        System.out.println("3: P B B F");
        System.out.println("4: P P ");
        System.out.println("5: P B P F");
        System.out.println("6: P B P W");
        System.out.println("7: P B P B W");
        System.out.println("8: P W ");
        System.out.println("9: P B W ");
        //2x tolunk, ket allapotot fedunk le
        //->switch.onStepped(box)
        //->switch.offStepped(box)
        System.out.println("10: P B S");
        System.out.println("11: P B H");
        System.out.println("12: P H");
        //2x tolunk, ket allapotot fedunk le
        //->boxot targetra tolunk
        //->boxot probalunk targetrol mozgatni
        System.out.println("13: P B T");
        System.out.println("0: EXIT ");
        System.out.println("Please choose a test case:");
    }

    public static void main(String[] args) {
        //Test map for the lockManagement method
        Game game = Game.getInstance();
        Scanner scanner = new Scanner(System.in);
        int command = -1;
        while (command != 0) {
            game.displaySkeletonMenu();
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    game.startGame("maps/skeleton1");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 2:
                    game.startGame("maps/skeleton2");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 3:
                    game.startGame("maps/skeleton3");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 4:
                    game.startGame("maps/skeleton4");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 5:
                    game.startGame("maps/skeleton5");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 6:
                    game.startGame("maps/skeleton6");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 7:
                    game.startGame("maps/skeleton7");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 8:
                    game.startGame("maps/skeleton8");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 9:
                    game.startGame("maps/skeleton9");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 10:
                    game.startGame("maps/skeleton10");
                    game.movePlayer(Direction.RIGHT);
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 11:
                    game.startGame("maps/skeleton11");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 12:
                    game.startGame("maps/skeleton12");
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 13:
                    game.startGame("maps/skeleton13");
                    game.movePlayer(Direction.RIGHT);
                    game.movePlayer(Direction.RIGHT);
                    break;
                case 0:

                    break;
                default:
                    break;
            }
        }

    }
}
