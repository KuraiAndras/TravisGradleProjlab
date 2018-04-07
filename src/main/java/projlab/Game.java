package projlab;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static String clearConsole = "\033[H\033[2J";
    private static String partialMapPath = "maps/playableMaps";

    private Game() {
        map = new WareHouse();
        playerScore = new HashMap<>();
        playerList = new LinkedHashSet<>();
        cyclicIterator = new CyclicIterator<>(playerList);
    }

    public static Game getInstance() {
        return ourInstance;
    }

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.playGameMenu();
    }

    //TODO: Fix illegal input
    private void playGameMenu() {
        ArrayList<String> mapList;
        Scanner scanner = new Scanner(System.in);

        int answer = -2;
        while (answer != -1) {
            mapList = displayPlayMenu();

            answer = scanner.nextInt();

            if (answer >= 0 && answer < mapList.size() - 1) {
                playGame(mapList.get(answer));
            } else if (answer == -1) {
                System.out.println("");
            } else {
                System.out.println("Bad Input");
            }
        }
        scanner.close();
    }

    private ArrayList<String> displayPlayMenu() {
        File directory = new File(partialMapPath);
        ArrayList<String> mapList = new ArrayList<>();

        System.out.println(clearConsole);
        System.out.println("Which map you want to play?");

        if (directory.isDirectory()) {
            String[] files = directory.list();
            Pattern pattern = Pattern.compile("^(.*?)\\.txt$");
            assert files != null;

            for (String file : files) {
                Matcher matcher = pattern.matcher(file);
                if (matcher.matches()) {
                    mapList.add(matcher.group(1));
                }
            }
        }

        System.out.println("-1: Exit");
        int i = 0;
        for (String map : mapList) {
            System.out.println(i++ + ": " + map);
        }

        ArrayList<String> filePaths = new ArrayList<>();
        for (String fileName : mapList) {
            filePaths.add(partialMapPath + '/' + fileName + ".txt");
        }

        return filePaths;
    }


    private void playGame(String mapPath) {
        loadGame(mapPath);
        Scanner scanner = new Scanner(System.in);
        int move = -1;
        while (move != 0) {
            move = scanner.nextInt();
            switch (move) {
                case 1:
                    movePlayer(Direction.LEFT);
                    break;
                case 2:
                    movePlayer(Direction.UP);
                    break;
                case 3:
                    movePlayer(Direction.DOWN);
                    break;
                case 4:
                    movePlayer(Direction.RIGHT);
                    break;
                case 5:
                    placeHoney();
                    break;
                case 6:
                    placeOil();
                    break;
                default:
                    break;
            }
        }
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

    private void logGame() {
        System.out.print(clearConsole);
        map.logMap();
        System.out.println("Number of players: " + playerScore.size());
        System.out.println("Movable boxes: " + movableBox);
        System.out.println("Current players:");
        for (Map.Entry<Player, Integer> item : playerScore.entrySet()) {
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
        logGame();
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
        logGame();
    }

    public ArrayList<ArrayList<Field>> getMap() {
        return map.getMap();
    }
}

