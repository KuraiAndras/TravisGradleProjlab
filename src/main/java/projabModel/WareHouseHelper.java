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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof WareHouseHelper)) return false;
        return this.id == ((WareHouseHelper) obj).id;
    }
}
