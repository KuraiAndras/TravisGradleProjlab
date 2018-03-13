package projlab;

public class WareHouseHelper {
    private int i;
    private int j;
    private int id;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(WareHouseHelper wareHouseHelper) {
        return this.id == wareHouseHelper.id;
    }
}
