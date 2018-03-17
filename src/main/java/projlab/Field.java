package projlab;

import java.util.HashMap;

//TODO: Add Javadoc
public class Field implements IStep {
    private HashMap<Direction, Field> neighbours;
    protected GameElement gameElement;

    public Field() {
        neighbours = new HashMap<>();
        gameElement = null;
    }



    public void setGameElement(GameElement gameElement) {
        this.gameElement = gameElement;
    }


    public boolean canElementMove() {
        return gameElement.getCanMove();
    }

    public boolean hasElement(){
        return gameElement != null;
    }

    public void lockElement(){
        gameElement.lockRequest();
    }

    public void setNeighbour(Field field, Direction direction) {
        neighbours.put(direction, field);
    }

    public HashMap<Direction, Field> getNeighbours(){
        return neighbours;
    }

    @Override
    public boolean onStepped(Player player, Direction direction) {
        if (gameElement == null) {
            gameElement = player;
            return true;
        }
        if (gameElement.collide(player, direction)) {
            gameElement = player;
            Game.getInstance().doLockManagement();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onStepped(Box box, Direction direction) {
        if (gameElement == null) {
            gameElement = box;
            return true;
        }
        if (gameElement.collide(box, direction)) {
            gameElement = box;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Field offStepped(Player player, Direction direction) {
        gameElement = null;
        return neighbours.get(direction);
    }

    @Override
    public Field offStepped(Box box, Direction direction) {
        gameElement = null;
        return neighbours.get(direction);
    }

    //TODO: Delete this
    @Override
    public String toString() {
        if(gameElement == null){
            return "Field";
        } else {
            return gameElement.toString();
        }
    }

}
