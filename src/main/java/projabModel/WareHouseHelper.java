package projabModel;

/**
 * Helper class for warehouse to store id-s and coordinates
 */
class WareHouseHelper {
    private int i;
    private int j;
    private int id;

    int getI() {
        return i;
    }

    void setI(int i) {
        this.i = i;
    }

    int getJ() {
        return j;
    }

    void setJ(int j) {
        this.j = j;
    }

    void setId(int id) {
        this.id = id;
    }

    /**
     * Equals by ID
     *
     * @param wareHouseHelper Target to equal
     * @return Returns match
     */
    boolean equals(WareHouseHelper wareHouseHelper) {
        return this.id == wareHouseHelper.id;
    }
}
