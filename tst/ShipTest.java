import org.junit.jupiter.api.Test;
import ship.Ship;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipTest {

    @Test
    void sampleTest() {
        System.out.println("test ship1");
    }

    @Test
    void sampleTestOne() {
        System.out.println("test ship");
    }

    @Test
    public void testGetter() {
        final int SHIP_LENGTH = 4;
        final int COL_LENGTH = 1;
        final int ROW_LENGTH = 2;
        Ship ship = new Ship(SHIP_LENGTH);
        ship.setCol(COL_LENGTH);
        ship.setRow(ROW_LENGTH);

        System.out.println(ship.getCol());
        System.out.println(ship.getRow());

        assertEquals(COL_LENGTH, ship.getCol());
        assertEquals(ROW_LENGTH, ship.getRow());
    }

    @Test
    public void testGetLength() {
        final int SHIP_LENGTH = 4;
        Ship ship = new Ship(SHIP_LENGTH);

        assertEquals(SHIP_LENGTH, ship.getLength());
    }

}
