package projlab;

/**
 * Helper class for warehouse to store id-s and coordinates
 */
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

    /**
     * Equals by ID
     * @param wareHouseHelper Target to equal
     * @return Returns match
     */
    public boolean equals(WareHouseHelper wareHouseHelper) {
        return this.id == wareHouseHelper.id;
    }
}
