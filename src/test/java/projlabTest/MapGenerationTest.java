package projlabTest;

import org.junit.Test;
import static org.junit.Assert.*;
import projabModel.WareHouse;

public class MapGenerationTest {

    @Test
    public void generationTestNoWall(){
        WareHouse wareHouse = new WareHouse();
        assertNull(wareHouse.generateMap("maps/wallErrorTest3.txt"));
    }

    @Test
    public void generationTestOneWallMissing(){
        WareHouse wareHouse = new WareHouse();
        assertNull(wareHouse.generateMap("maps/wallErrorTest2.txt"));
    }

    @Test
    public void generationTestWorking(){
        WareHouse wareHouse = new WareHouse();
        assertNotNull(wareHouse.generateMap("maps/wallErrorTest1.txt"));
    }
}
