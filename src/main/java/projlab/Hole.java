package projlab;

//TODO: Add Javadoc
public class Hole extends Field {
    private boolean isOpen;

    public Hole(boolean isOpen) {
        super();
        this.isOpen = isOpen;
    }

    public void switchHole() {
        isOpen = !isOpen;
        if(isOpen==true && gameElement!=null)
            gameElement=null;
    }

    @Override
    public boolean onStepped(Player player, Direction direction) {
        if (!isOpen) {
            return super.onStepped(player, direction);
        } else {
            player.die();
            //This may kill the whole program?
            return false;
        }
    }

    @Override
    public boolean onStepped(Box box, Direction direction) {
        if (!super.onStepped(box, direction))
            return false;
        else {
            if (!isOpen) {
                gameElement = null;
                Game.getInstance().decreaseMovableBox();
            }
            return true;
        }
    }
    //TODO: Delete this
    @Override
    public String toString()
    {
        if(gameElement == null){
            return "Hole";
        } else {
            return gameElement.toString();
        }
    }

}
