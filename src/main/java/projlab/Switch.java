package projlab;

//TODO: Add Javadoc
public class Switch extends Field {
    private Hole pair;

    public Switch() {
        super();
        pair = null;
    }

    //TODO: Warehouse must set hole's is hole open properly before using it as a parameter
    public void setPair(Hole pair) {
        this.pair = pair;
    }

    @Override
    public boolean onStepped(Box box, Direction direction) {
        pair.switchHole();
        return super.onStepped(box, direction);
    }

    @Override
    public Field offStepped(Box box, Direction direction) {
        pair.switchHole();
        return super.offStepped(box, direction);
    }

    //TODO: Delete this
    @Override
    public String toString() {
        return "Switch";
    }
}
