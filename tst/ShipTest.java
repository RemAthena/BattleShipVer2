import org.junit.jupiter.api.Test;
import ship.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipTest {
    @Test
    public void testGetterSetterOne() {
        final int SHIP_LENGTH = 1;
        final int COL_LENGTH = 1;
        final int ROW_LENGTH = 2;
        final boolean HORIZONTAL_STATE = true;
        final boolean WAS_HIT = true;
        final boolean NOT_HIT = false;
        Ship ship = new ShipOne();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_LENGTH);
        ship.setRow(ROW_LENGTH);

        assertEquals(HORIZONTAL_STATE, ship.isHorizontal());
        assertEquals(SHIP_LENGTH, ship.getLength());
        assertEquals(COL_LENGTH, ship.getCol());
        assertEquals(ROW_LENGTH, ship.getRow());
        assertEquals(NOT_HIT, ship.isSunk());

        ship.setWasHit(SHIP_LENGTH-1, WAS_HIT);
        assertEquals(WAS_HIT, ship.isSunk());
    }

    @Test
    public void testGetterSetterTwo() {
        final int SHIP_LENGTH = 2;
        final int COL_LENGTH = 3;
        final int ROW_LENGTH = 4;
        final boolean HORIZONTAL_STATE = false;
        final boolean WAS_HIT = true;
        final boolean NOT_HIT = false;
        Ship ship = new ShipTwo();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_LENGTH);
        ship.setRow(ROW_LENGTH);

        assertEquals(HORIZONTAL_STATE, ship.isHorizontal());
        assertEquals(SHIP_LENGTH, ship.getLength());
        assertEquals(COL_LENGTH, ship.getCol());
        assertEquals(ROW_LENGTH, ship.getRow());

        for(int i = 0; i < SHIP_LENGTH; i++){
            assertEquals(NOT_HIT, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
        }
        assertEquals(WAS_HIT, ship.isSunk());
    }

    @Test
    public void testGetterSetterThree() {
        final int SHIP_LENGTH = 3;
        final int COL_LENGTH = 5;
        final int ROW_LENGTH = 6;
        final boolean HORIZONTAL_STATE = false;
        final boolean WAS_HIT = true;
        final boolean NOT_HIT = false;
        Ship ship = new ShipThree();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_LENGTH);
        ship.setRow(ROW_LENGTH);

        assertEquals(HORIZONTAL_STATE, ship.isHorizontal());
        assertEquals(SHIP_LENGTH, ship.getLength());
        assertEquals(COL_LENGTH, ship.getCol());
        assertEquals(ROW_LENGTH, ship.getRow());

        for (int i = 0; i < SHIP_LENGTH; i++) {
            assertEquals(NOT_HIT, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
        }
        assertEquals(WAS_HIT, ship.isSunk());
    }

    @Test
    public void testGetterSetterFour() {
        final int SHIP_LENGTH = 4;
        final int COL_LENGTH = 5;
        final int ROW_LENGTH = 2;
        final boolean HORIZONTAL_STATE = true;
        final boolean WAS_HIT = true;
        final boolean NOT_HIT = false;
        Ship ship = new ShipFour();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_LENGTH);
        ship.setRow(ROW_LENGTH);

        assertEquals(HORIZONTAL_STATE, ship.isHorizontal());
        assertEquals(SHIP_LENGTH, ship.getLength());
        assertEquals(COL_LENGTH, ship.getCol());
        assertEquals(ROW_LENGTH, ship.getRow());

        for (int i = 0; i < SHIP_LENGTH; i++) {
            assertEquals(NOT_HIT, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
        }
        assertEquals(WAS_HIT, ship.isSunk());
    }
}
