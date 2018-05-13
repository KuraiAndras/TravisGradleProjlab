package projlabTest;

import org.junit.Test;
import projabModel.MapException;
import projabModel.WareHouse;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MapGenerationTest {

    @Test(expected = MapException.class)
    public void generationTestNoWall() throws Exception {
        WareHouse wareHouse = new WareHouse();
        wareHouse.generateMap("maps/wallErrorTestNoWall.txt");
    }

    @Test(expected = MapException.class)
    public void generationTestOneWallMissing() throws Exception{
        WareHouse wareHouse = new WareHouse();
        assertNull(wareHouse.generateMap("maps/wallErrorTestOneMissing.txt"));
    }

    @Test
    public void generationTestWorking() throws Exception{
        WareHouse wareHouse = new WareHouse();
        assertNotNull(wareHouse.generateMap("maps/wallErrorTestWorks.txt"));
    }
}
