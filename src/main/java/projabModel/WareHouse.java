package projabModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TODO: Add Javadoc//TODO: Delete logging
public class WareHouse {
    private ArrayList<ArrayList<Field>> map;

    public WareHouse() {
        map = new ArrayList<>();
    }

    //Why need the whole map?
    ArrayList<ArrayList<Field>> getMap() {
        return map;
    }

    //Todo: Throw exception when map is not surrounded with walls
    public WareHouse generateMap(String mapLocation) throws Exception{
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

            file.close();

            for (ArrayList<String> item :
                    charMap) {
                if (item.size() != charMap.get(0).size()) {
                    throw new MapException("Map file has varying lines");
                }
            }

            for (int i = 0; i < charMap.size(); i++) {
                for (int j = 0; j < charMap.get(0).size(); j++) {
                    if (((i == 0 || i == charMap.size() - 1) && !charMap.get(i).get(j).equals("W")) || ((j == 0 || j == charMap.get(0).size() - 1) && !charMap.get(i).get(j).equals("W"))) {
                        throw new MapException("Map is Not Surrounded with Walls");
                    }
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
                            Game.getInstance().registerBox();
                            line.add(field);
                        }
                        break;
                        case "P": {
                            Field field = new Field();
                            Player player = new Player(field);
                            field.setGameElement(player);
                            Game.getInstance().registerPlayer(player);
                            line.add(field);
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
        return this;
    }

    //Iterates trough all the fields in the map object to lock a box if needed
    //Should be called after every step that caused collision ( ?? maybe after every step ?? )
    void lockManagement() {
        //We need to go trough all the fields for the number of movable boxes
        //to handle every possible lock that needs to occur after a lock
        int boxesLeft = Game.getInstance().getMovableBox();
        while (boxesLeft > 0) {
            int rowNum = 0;
            int colNum = 0;
            firstLoop:
            for (int row = 0; row < map.size(); row++, rowNum++) {
                for (int column = 0; column < map.get(row).size(); column++, colNum++) {
                    //Current field
                    Field current = map.get(row).get(column);
                    //If there is no element we just skip it
                    //If the gameElement is already locked we skip it
                    if (current.hasElement() && current.canElementMove()) {
                        //Storing neighbours of current Field
                        HashMap<Direction, Field> neighbours = current.getNeighbours();
                        /*
                        Checking for a possible block to trigger a lockRequest
                        Possible blocks:
                        up + left, up + right
                        down + left, down + right
                        */
                        //Checking cases involving the upper neighbour
                        if (neighbours.get(Direction.UP) != null) {
                            Field up = neighbours.get(Direction.UP);
                            Field left = neighbours.get(Direction.LEFT);
                            Field right = neighbours.get(Direction.RIGHT);
                            if (up.hasElement()) {
                                //UP + LEFT
                                if (left.hasElement()) {
                                    if (!up.canElementMove() && !left.canElementMove()) {
                                        //TODO: Delete logging
                                        // System.out.println("-LOCKING --" + String.valueOf(row) + "-" + String.valueOf(column) + "  ");
                                        current.lockElement();
                                        break firstLoop;
                                    }
                                }
                                //UP + RIGHT
                                if (right.hasElement()) {
                                    if (!up.canElementMove() && !right.canElementMove()) {
                                        //TODO: Delete logging
                                        //System.out.println("-LOCKING --" + String.valueOf(row) + "-" + String.valueOf(column) + "  ");
                                        current.lockElement();
                                        break firstLoop;
                                    }
                                }
                            }
                        }
                        //Checking cases involving the bottom neighbour
                        if (neighbours.get(Direction.DOWN) != null) {
                            Field down = neighbours.get(Direction.DOWN);
                            Field left = neighbours.get(Direction.LEFT);
                            Field right = neighbours.get(Direction.RIGHT);
                            if (down.hasElement()) {
                                //DOWN + LEFT
                                if (left.hasElement()) {
                                    if (!down.canElementMove() && !left.canElementMove()) {
                                        //TODO: Delete logging
                                        //System.out.println("-LOCKING --" + String.valueOf(row) + "-" + String.valueOf(column) + "  ");
                                        current.lockElement();
                                        break firstLoop;
                                    }
                                }
                                //DOWN + RIGHT
                                if (right.hasElement()) {
                                    if (!down.canElementMove() && !right.canElementMove()) {
                                        //TODO: Delete logging
                                        //System.out.println("-LOCKING --" + String.valueOf(row) + "-" + String.valueOf(column) + "  ");
                                        current.lockElement();
                                        break firstLoop;
                                    }
                                }
                            }
                        }
                    }
                    //If there is an unlocked gameElement we check if we need to lock it


                }
                //TODO: Delete logging
                //System.out.println();
                colNum = 0;
            }
            boxesLeft--;
            if (rowNum == map.size() && colNum == map.get(0).size()) {
                break;
            }
        }
    }
}