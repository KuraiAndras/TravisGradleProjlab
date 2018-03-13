//TODO: Add Javadoc
public class Target extends Field {
    @Override
    public boolean onStepped(Box box, Direction direction) {
        if (gameElement == null) {
            gameElement = box;
            Game.getInstance().incrementScore();
            box.lockRequest();
            return true;
        }
        if (gameElement.collide(box, direction)) {
            gameElement = box;
            Game.getInstance().incrementScore();
            box.lockRequest();
            return true;
        } else {
            return false;
        }
    }

    //TODO: Delete this
    @Override
    public String toString() {
        return "Target";
    }
}
