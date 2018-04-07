package projlab;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProtoTest {


    public ProtoTest(){

    }


    private static List<String> listMap(Game game){
        List<String> map = new ArrayList<>();
        map.addAll(listWalls(game));
        map.addAll(listTargets(game));
        map.addAll(listSwitches(game));
        map.addAll(listPlayers(game));
        map.addAll(listHoles(game));
        map.addAll(listEmptyFields(game));
        map.addAll(listBoxes(game));
        return map;
    }
    
    private static List<String> listPlayers(Game game) {
        List<String> players = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k).hasElement()) {
                    if (game.getMap().get(i).get(k).gameElement instanceof Player) {
                        players.add(String.format("%d (%d,%d) Player", id, i, k));
                        id++;
                    }
                }
            }

        }
        return players;
    }

    private static List<String> listBoxes(Game game) {
        List<String> boxes = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k).hasElement()) {
                    if (game.getMap().get(i).get(k).gameElement instanceof Box) {
                        boxes.add(String.format("%d (%d,%d) Box %s", id, i, k,
                                Boolean.toString(game.getMap().get(i).get(k).gameElement.getCanMove())));
                        id++;
                    }
                }
            }
        }
        return boxes;
    }

    private static List<String> listWalls(Game game) {
        List<String> walls = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k).hasElement()) {
                    if (game.getMap().get(i).get(k).gameElement instanceof  Wall) {
                        walls.add(String.format("%d (%d,%d) Wall", id, i, k));
                        id++;
                    }
                }
            }

        }
        return walls;
    }

    private static List<String> listEmptyFields(Game game) {
        List<String> fields = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (!game.getMap().get(i).get(k).hasElement()) {
                    fields.add(String.format("%d (%d,%d) Field %.1f", id, i, k, game.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }
        }
        return fields;
    }

    private static List<String> listSwitches(Game game) {
        List<String> switches = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k) instanceof Switch) {
                    switches.add(String.format("%d (%d,%d) Switch %.1f", id, i, k, game.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }
        }
        return switches;
    }

    private static List<String> listTargets(Game game) {
        List<String> targets = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k) instanceof Target) {
                    targets.add(String.format("%d (%d,%d) Target %.1f", id, i, k, game.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return targets;
    }

    private static List<String> listHoles(Game game) {
        List<String> holes = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < game.getMap().size(); i++) {
            for (int k = 0; k < game.getMap().get(i).size(); k++) {
                if (game.getMap().get(i).get(k) instanceof Hole) {
                    holes.add(String.format("%d (%d,%d) Hole %s %.1f", id, i, k,
                            Boolean.toString(((Hole) game.getMap().get(i).get(k)).getIsOpen()),
                            game.getMap().get(i).get(k).getStickiness()));
                    id++;
                }
            }

        }
        return holes;
    }


    private static ArrayList<String> readFile(String fin) throws IOException {
        ArrayList<String> out = new ArrayList<>();
        File file = new File(fin);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            out.add(line);
        }
        br.close();
        return out;
    }

    private static ArrayList<String[]> processInput(ArrayList<String> input) {
        ArrayList<String[]> separated = new ArrayList<>();
        for (String line : input) {
            separated.add(line.split(" "));
        }
        return separated;
    }

    private static void execute(Game game, ArrayList<String[]> commands) {
        for (String[] command1 : commands) {
            if (command1.length > 1) {
                String command = command1[0];
                String arg = command1[1];

                switch (command) {
                    case "loadMap":
                        game.loadGame(arg);
                        game.doLockManagement();
                        break;
                    case "stepPlayer":
                        game.movePlayer(Direction.valueOf(arg));
                        break;
                }
            } else {
                String command = command1[0];
                switch (command) {
                    case "listMap":
                        writeResults(listMap(game));
                        break;
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

    private static void writeResults(List<String> res) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("proto_tests/testResult.txt"), "utf-8"))) {
            for (int i = 0; i < res.size(); i++) {
                writer.write(res.get(i));
                if (i < res.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void diffFiles(String firstFilePath, String secondFilePath) {
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
        List<String> diff = new ArrayList<>();
        for (String line : firstFileContent) {
            if (!secondFileContent.contains(line)) {
                diff.add((firstFileContent.indexOf(line) + 1) + " " + line);
            }
        }

        if (diff.size() == 0) {
            System.out.println("!!!!!!!!!!!!!!!");
            System.out.println("Test successful");
            System.out.println("!!!!!!!!!!!!!!!");
        } else {
            System.out.println("!!!!!!!!!!!!!!!");
            System.out.println("Difference:");
            System.out.println(diff.toString());
            System.out.println("!!!!!!!!!!!!!!!");
        }
    }

    private void displayProtoMenu() {
        System.out.flush();
        System.out.println("Welcome to We <3 IIT proto test");
        System.out.println("1: Check generated players");
        System.out.println("2: Check generated boxes ");
        System.out.println("3: Check generated walls ");
        System.out.println("4: Check generated empty fields ");
        System.out.println("5: Check generated switches ");
        System.out.println("6: Check generated holes");
        System.out.println("7: Check generated targets");
        System.out.println("8: Check generated map");
        System.out.println("9: Player pushes box successfully");
        System.out.println("10: Player can't push the box");
        System.out.println("11: Box reaches target and locks");
        System.out.println("12: Player steps into hole and dies");
        System.out.println("13: Player dies between boxes");
        System.out.println("14: Player puts honey and field becomes sticky");
        System.out.println("15: Player puts oil and field becomes slippery");
        System.out.println("0: Exit ");
        System.out.println("Please choose one:");
    }

    public void runTestMenu(Game game){
        Scanner scanner = new Scanner(System.in);

        int answer = -1;
        while (answer != 0) {
            displayProtoMenu();
            answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listPlayerTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listPlayerTest_out.txt");

                    break;
                case 2:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listBoxesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listBoxesTest_out.txt");
                    break;
                case 3:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listWallsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listWallsTest_out.txt");
                    break;
                case 4:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listEmptyFieldsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listEmptyFieldsTest_out.txt");
                    break;
                case 5:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listSwitchesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listSwitchesTest_out.txt");
                    break;
                case 6:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listHolesTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listHolesTest_out.txt");
                    break;
                case 7:
                    try {
                        ArrayList<String> in = readFile("proto_tests/listTargetsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/listTargetsTest_out.txt");
                    break;
                case 8:
                    try {
                        ArrayList<String> in = readFile("proto_tests/loadMapTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/loadMapTest_out.txt");
                    break;
                case 9:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerPushesBoxSuccessTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerPushesBoxSuccessTest_out.txt");
                    break;
                case 10:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerPushesBoxFailsTest_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerPushesBoxFailsTest_out.txt");
                    break;
                case 11:
                    try {
                        ArrayList<String> in = readFile("proto_tests/boxReachesTarget_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/boxReachesTarget_out.txt");
                    break;
                case 12:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerStepsIntoHole_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerStepsIntoHole_out.txt");
                    break;
                case 13:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerDiesBetweenBoxes_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerDiesBetweenBoxes_out.txt");
                    break;
                case 14:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerPutsHoney_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerPutsHoney_out.txt");
                    break;
                case 15:
                    try {
                        ArrayList<String> in = readFile("proto_tests/playerPutsOil_in.txt");
                        execute(game, processInput(in));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    diffFiles("proto_tests/testResult.txt", "proto_tests/playerPutsOil_out.txt");
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

}
