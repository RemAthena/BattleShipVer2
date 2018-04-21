import org.junit.jupiter.api.Test;
import ship.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipTest {
    final boolean WAS_HIT = true;
    final boolean NOT_HIT = false;
    final boolean WAS_SUNK = true;
    final boolean NOT_SUNK = false;
    final boolean IS_SHIP = true;
    final boolean NOT_SHIP = false;
    final String SHIP_SUNK_STR = "X ";
    final String NOT_SUNK_STR = "O ";
    final String MISS_SUNK_STR = "* ";
    final String CHEAT_SHIP_STR = "1 ";
    final String CHEAT_OCEAN_STR = "0 ";

    @Test
    public void testShipOne() {
        final int COL_NUM = 1;
        final int ROW_NUM = 2;
        final boolean HORIZONTAL_STATE = true;

        Ship ship = new ShipOne();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_NUM);
        ship.setRow(ROW_NUM);

        // Test getWasHit(), isSunk() and toString()
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_HIT, ship.getWasHit()[i]);
            assertEquals(NOT_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()));
        }
        assertEquals(CHEAT_SHIP_STR, ship.toString());
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_SUNK, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
            assertEquals(SHIP_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()+i));
            assertEquals(WAS_HIT, ship.getWasHit()[i]);
        }
        assertEquals(WAS_SUNK, ship.isSunk());

        // Test isShip()
        assertEquals(IS_SHIP, ship.isShip());
    }

    @Test
    public void testShipTwo() {
        final int COL_NUM = 3;
        final int ROW_NUM = 4;
        final boolean HORIZONTAL_STATE = false;

        Ship ship = new ShipTwo();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_NUM);
        ship.setRow(ROW_NUM);

        // Test getWasHit(), isSunk() and toString()
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_HIT, ship.getWasHit()[i]);
            assertEquals(NOT_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()));
        }
        assertEquals(CHEAT_SHIP_STR, ship.toString());
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_SUNK, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
            assertEquals(SHIP_SUNK_STR, ship.toString(ship.getRow()+i, ship.getCol()));
            assertEquals(WAS_HIT, ship.getWasHit()[i]);
        }
        assertEquals(WAS_SUNK, ship.isSunk());

        // Test isShip()
        assertEquals(IS_SHIP, ship.isShip());
    }

    @Test
    public void testShipThree() {
        final int COL_NUM = 5;
        final int ROW_NUM = 6;
        final boolean HORIZONTAL_STATE = false;

        Ship ship = new ShipThree();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_NUM);
        ship.setRow(ROW_NUM);

        // Test getWasHit(), isSunk() and toString()
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_HIT, ship.getWasHit()[i]);
            assertEquals(NOT_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()));
        }
        assertEquals(CHEAT_SHIP_STR, ship.toString());
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_SUNK, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
            assertEquals(SHIP_SUNK_STR, ship.toString(ship.getRow()+i, ship.getCol()));
            assertEquals(WAS_HIT, ship.getWasHit()[i]);
        }
        assertEquals(WAS_SUNK, ship.isSunk());

        // Test isShip()
        assertEquals(IS_SHIP, ship.isShip());
    }

    @Test
    public void testShipFour() {
        final int COL_NUM = 5;
        final int ROW_NUM = 2;
        final boolean HORIZONTAL_STATE = true;

        Ship ship = new ShipFour();
        ship.setHorizontal(HORIZONTAL_STATE);
        ship.setCol(COL_NUM);
        ship.setRow(ROW_NUM);

        // Test getWasHit(), isSunk() and toString()
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_HIT, ship.getWasHit()[i]);
            assertEquals(NOT_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()));
        }
        assertEquals(CHEAT_SHIP_STR, ship.toString());
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_SUNK, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
            assertEquals(SHIP_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()+i));
            assertEquals(WAS_HIT, ship.getWasHit()[i]);
        }
        assertEquals(WAS_SUNK, ship.isSunk());

        // Test isShip()
        assertEquals(IS_SHIP, ship.isShip());
    }

    @Test
    public void testEmptyOcean() {
        final int COL_NUM = 7;
        final int ROW_NUM = 7;

        Ship ship = new EmptyOcean(ROW_NUM, COL_NUM);

        // Test getWasHit(), isSunk() and toString()
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_HIT, ship.getWasHit()[i]);
            assertEquals(NOT_SUNK_STR, ship.toString(ship.getRow(), ship.getCol()));
        }
        assertEquals(CHEAT_OCEAN_STR, ship.toString());
        for(int i = 0; i < ship.getLength(); i++){
            assertEquals(NOT_SUNK, ship.isSunk());
            ship.setWasHit(i, WAS_HIT);
            assertEquals(MISS_SUNK_STR, ship.toString(ROW_NUM, COL_NUM+i));
            assertEquals(WAS_HIT, ship.getWasHit()[i]);
        }
        assertEquals(WAS_SUNK, ship.isSunk());

        // Test isShip()
        assertEquals(NOT_SHIP, ship.isShip());
    }
}

