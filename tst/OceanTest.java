import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OceanTest {
    @Test
    public void testGetShips() {
        Ocean ocean = new Ocean();
        assertEquals(10, ocean.getShips().length);
        assertEquals(10, ocean.getShips()[0].length);
    }

    @Test
    public void testPlaceShip() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for (int i = 0; i < ocean.getShips().length; i++) {
            for (int j = 0; j < ocean.getShips()[0].length; j++) {
                if (!ocean.isGameOver()) {
                    ocean.print();
                    ocean.fire(i, j);
                }
                else {
                    ocean.print();
                    ocean.cheat();
                    return;
                }
            }
        }
    }

    @Test
    public void test2DArray() {
        int[][] a = new int[3][3];
        for (int[] item : a) {
            for (int i : item) {
                System.out.print(i);
            }
        }
    }
}
