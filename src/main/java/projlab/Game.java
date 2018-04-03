package projlab;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Scanner scanner = new Scanner(System.in);

        int answer = -1;
        while (answer != 0) {
            game.displayProtoMenu();
            answer = scanner.nextInt();
            List<String> difference;
            switch (answer) {
                case 1:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listPlayerTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listPlayerTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 2:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listBoxesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listBoxesTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 3:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listWallsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listWallsTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 4:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listEmptyFieldsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listEmptyFieldsTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 5:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listSwitchesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listSwitchesTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 6:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listHolesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listHolesTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 7:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listTargetsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    difference = diffFiles("proto_tests/testResult.txt", "proto_tests/listTargetsTest_out.txt");
                    if (difference.size() == 0) {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Test successful");
                        System.out.println("!!!!!!!!!!!!!!!");
                    } else {
                        System.out.println("!!!!!!!!!!!!!!!");
                        System.out.println("Difference:");
                        System.out.println(difference.toString());
                        System.out.println("!!!!!!!!!!!!!!!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid test file!");
                    break;
            }
        }
        scanner.close();
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
        logGame();
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
        // logGame();
    }


    /*
    Proto tests starting from here

     */

    private void displayProtoMenu() {
        System.out.flush();
        System.out.println("Welcome to We <3 IIT skeleton");
        System.out.println("1: Check generated players");
        System.out.println("2: Check generated boxes ");
        System.out.println("3: Check generated walls ");
        System.out.println("4: Check generated empty fields ");
        System.out.println("5: Check generated switches ");
        System.out.println("6: Check generated holes");
        System.out.println("7: Check generated targets");
        System.out.println("0: Exit ");
        System.out.println("Please choose one:");
    }

    private static void loadMap(Game game, String path) {
        game.startGame(path);
    }

    private static List<String> listPlayers(Game game) {
        List<String> players = new ArrayList<String>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k).hasElement()) {
                    if (game.map.getMap().get(i).get(k).gameElement.weight == 0.5) {
                        players.add(String.format("%d (%d,%d) Player", id, i, k));
                        id++;
                    }
                }
            }

        }
        return players;
    }

    private static List<String> listBoxes(Game game) {
        List<String> boxes = new ArrayList<String>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k).hasElement()) {
                    if (game.map.getMap().get(i).get(k).gameElement.weight == 1) {
                        boxes.add(String.format("%d (%d,%d) Box %s", id, i, k,
                                Boolean.toString(game.map.getMap().get(i).get(k).gameElement.getCanMove())));
                        id++;
                    }
                }
            }

        }
        return boxes;
    }

    private static List<String> listWalls(Game game) {
        List<String> walls = new ArrayList<String>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k).hasElement()) {
                    if (game.map.getMap().get(i).get(k).gameElement.weight == Double.MAX_VALUE) {
                        walls.add(String.format("%d (%d,%d) Wall", id, i, k));
                        id++;
                    }
                }
            }

        }
        return walls;
    }

    private static List<String> listEmptyFields(Game game) {
        List<String> fields = new ArrayList<String>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (!game.map.getMap().get(i).get(k).hasElement()) {
                    fields.add(String.format("%d (%d,%d) Field %.1f", id, i, k, game.map.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return fields;
    }

    private static List<String> listSwitches(Game game) {
        List<String> switches = new ArrayList<String>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k) instanceof Switch) {
                    switches.add(String.format("%d (%d,%d) Switch %.1f", id, i, k, game.map.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return switches;
    }

    private static List<String> listTargets(Game game) {
        List<String> targets = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k) instanceof Target) {
                    targets.add(String.format("%d (%d,%d) Target %.1f", id, i, k, game.map.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return targets;
    }

    private static List<String> listHoles(Game game) {
        List<String> holes = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.map.getMap().size(); i++) {
            for (int k = 0; k < game.map.getMap().get(i).size(); k++) {
                if (game.map.getMap().get(i).get(k) instanceof Hole) {
                    holes.add(String.format("%d (%d,%d) Hole %s %.1f", id, i, k,
                            Boolean.toString(((Hole) game.map.getMap().get(i).get(k)).getIsOpen()),
                            game.map.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return holes;
    }

    private static void stepPlayer(Game game, Direction dir) {
        game.currentTurn.move(dir);
    }

    private static void stepBox(Game game, Direction dir) {
        Box temp = new Box();
        game.map.getMap().get(2).get(1).gameElement.collide(temp, dir, 5.5);
    }

    private static ArrayList<String> readFile(String fin) throws IOException {
        ArrayList<String> out = new ArrayList<String>();
        File file = new File(fin);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            out.add(line);
        }
        br.close();
        return out;
    }

    private static ArrayList<String[]> processInput(ArrayList<String> input) {
        ArrayList<String[]> separated = new ArrayList<String[]>();
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            separated.add(line.split(" "));
        }
        return separated;
    }

    private static void execute(Game game, ArrayList<String[]> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).length > 1) {
                String command = commands.get(i)[0];
                String arg = commands.get(i)[1];

                switch (command) {
                    case "loadMap":
                        game.startGame(arg);
                        game.doLockManagement();
                        break;
                    case "stepPlayer":
                        stepPlayer(game, Direction.valueOf(arg));
                        break;
                    case "stepBox":
                        stepBox(game, Direction.valueOf(arg));
                }
            } else {
                String command = commands.get(i)[0];
                switch (command) {
                    case "listPlayers":
                        writeResults(listPlayers(game));
                        break;
                    case "listBoxes":
                        writeResults(listBoxes(game));
                        break;
                    case "listWalls":
                        writeResults(listWalls(game));
                        break;
                    case "listEmptyFields":
                        writeResults(listEmptyFields(game));
                        break;
                    case "listTargets":
                        writeResults(listTargets(game));
                        break;
                    case "listSwitches":
                        writeResults(listSwitches(game));
                        break;
                    case "listHoles":
                        writeResults(listHoles(game));
                        break;
                    case "putOil":
                        game.placeOil();
                        break;
                    case "putHoney":
                        game.placeHoney();
                }
            }

        }

    }

    public static void writeResults(List<String> res) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("proto_tests/testResult.txt"), "utf-8"))) {
            for (int i = 0; i < res.size(); i++) {
                writer.write(res.get(i));
                if (i < res.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> diffFiles(String firstFilePath,
                                          String secondFilePath) {
        Path firstFile = Paths.get(firstFilePath);
        Path secondFile = Paths.get(secondFilePath);
        List<String> firstFileContent = null;
        try {
            firstFileContent = Files.readAllLines(firstFile,
                    Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> secondFileContent = null;
        try {
            secondFileContent = Files.readAllLines(secondFile,
                    Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> diff = new ArrayList<String>();
        for (String line : firstFileContent) {
            if (!secondFileContent.contains(line)) {
                diff.add((firstFileContent.indexOf(line) + 1) + " " + line);
            }
        }
        return diff;
    }
}
