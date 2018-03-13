package projlabTest;

import projlab.*;
import java.io.*;
import java.util.*;

public class FakeWarehouse extends WareHouse {
    FakeWarehouse() {
        super();
    }

    public Player generateTestMapPlayer(String mapLocation) {
        Player rePlayer = null;
        try {
            ArrayList<ArrayList<String>> charMap = new ArrayList<>();
            Scanner file = new Scanner(new File(mapLocation));
            //Reading from file
            while (file.hasNextLine()) {
                ArrayList<String> line = new ArrayList<>();
                final String nextLine = file.nextLine();
                final String[] items = nextLine.split(",");

                Collections.addAll(line, items);

                charMap.add(line);
                Arrays.fill(items, null);
            }

            for (ArrayList<String> item :
                    charMap) {
                if (item.size() != charMap.get(0).size()) {
                    throw new MapException("Map file has varying lines");
                }
            }

            //Helpers for setting switches and holes correctly
            ArrayList<WareHouseHelper> switchHelper = new ArrayList<>();
            ArrayList<WareHouseHelper> holeHelper = new ArrayList<>();
            //Creating fields from string
            for (ArrayList<String> aCharMap : charMap) {
                ArrayList<Field> line = new ArrayList<>();
                for (String anACharMap : aCharMap) {
                    switch (anACharMap) {
                        case "F":
                            line.add(new Field());
                            break;
                        case "T":
                            line.add(new Target());
                            break;
                        case "B": {
                            Field field = new Field();
                            Box box = new Box(field);
                            field.setGameElement(box);
                            //Game.getInstance().registerBox();
                            line.add(field);
                        }
                        break;
                        case "P": {
                            //creating unique ID
                            UUID uuid = UUID.randomUUID();
                            /*while (!Game.getInstance().registerPlayer(uuid)) {
                                uuid = UUID.randomUUID();
                            }*/
                            Field field = new Field();
                            Player player = new Player(uuid, field);
                            field.setGameElement(player);
                            line.add(field);
                            rePlayer = player;
                        }
                        break;
                        case "W": {
                            Field field = new Field();
                            Wall wall = new Wall(field);
                            field.setGameElement(wall);
                            line.add(field);
                        }
                        break;
                        case "H":
                            line.add(new Hole(true));
                            break;
                        default: {
                            //if its not a single character then the string is a regex
                            if (anACharMap.matches("[H][0-9]") || anACharMap.matches("[H][0-9][0-9]") || anACharMap.matches("[H][0-9][0-9][0-9]")) {
                                Hole hole = new Hole(false);
                                WareHouseHelper tempHole = new WareHouseHelper();
                                tempHole.setId(Integer.parseInt(anACharMap.substring(1)));
                                tempHole.setI(map.size());
                                tempHole.setJ(line.size());
                                holeHelper.add(tempHole);
                                line.add(hole);
                            } else if (anACharMap.matches("[S][0-9]") || anACharMap.matches("[S][0-9][0-9]") || anACharMap.matches("[S][0-9][0-9][0-9]")) {
                                Switch aSwitch = new Switch();
                                WareHouseHelper tempSwitch = new WareHouseHelper();
                                tempSwitch.setId(Integer.parseInt(anACharMap.substring(1)));
                                tempSwitch.setI(map.size());
                                tempSwitch.setJ(line.size());
                                switchHelper.add(tempSwitch);
                                line.add(aSwitch);
                            } else {
                                throw new MapException("Invalid character in map: " + anACharMap);
                            }
                        }
                        break;
                    }
                }
                map.add(line);
            }

            if (switchHelper.size() != holeHelper.size()) {
                throw new MapException("Different number of connected switches and holes");
            }

            //Setting switch-hole pairs, based on WarehouseHelper lists
            for (WareHouseHelper switches :
                    switchHelper) {
                for (WareHouseHelper holes :
                        holeHelper) {
                    if (holes.equals(switches)) {
                        Hole tempHole = new Hole(false);
                        Switch tempSwitch = new Switch();
                        tempSwitch.setPair(tempHole);
                        map.get(holes.getI()).set(holes.getJ(), tempHole);
                        map.get(switches.getI()).set(switches.getJ(), tempSwitch);
                    }
                }
            }
            //Setting neighbours
            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    if (i - 1 < 0) {
                        map.get(i).get(j).setNeighbour(null, Direction.UP);
                    } else {
                        map.get(i).get(j).setNeighbour(map.get(i - 1).get(j), Direction.UP);
                    }
                    if (j - 1 < 0) {
                        map.get(i).get(j).setNeighbour(null, Direction.LEFT);
                    } else {
                        map.get(i).get(j).setNeighbour(map.get(i).get(j - 1), Direction.LEFT);
                    }
                    if (i + 1 >= map.size()) {
                        map.get(i).get(j).setNeighbour(null, Direction.DOWN);
                    } else {
                        map.get(i).get(j).setNeighbour(map.get(i + 1).get(j), Direction.DOWN);
                    }
                    if (j + 1 >= map.get(i).size()) {
                        map.get(i).get(j).setNeighbour(null, Direction.RIGHT);
                    } else {
                        map.get(i).get(j).setNeighbour(map.get(i).get(j + 1), Direction.RIGHT);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file could not be found!");
            return null;
        } catch (MapException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return rePlayer;
    }
}
