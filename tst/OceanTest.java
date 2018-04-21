import org.junit.jupiter.api.Test;

public class OceanTest {
    @Test
    public void testOcean() {
        Ocean ocean = new Ocean();
        ocean.print();
        ocean.cheat();
    }

    @Test
    public void testPlaceShip() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.print();
        ocean.cheat();
    }

    @Test
    public void testFireAndGameOver() {
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for (int i = 0; i < ocean.getShips().length; i++) {
            for (int j = 0; j < ocean.getShips()[0].length; j++) {
                if (!ocean.isGameOver()) {
                    ocean.print();
                    fireResult result = ocean.fire(i, j);
                    if(result == fireResult.MISS) {
                        System.out.println("You missed.");
                    }
                    else if(result == fireResult.HIT) {
                        System.out.println("You hit.");
                    }
                    else {
                        System.out.println("You already fired on this cell.");
                    }
                }
                else {
                    ocean.print();
                    ocean.cheat();
                    return;
                }
            }
        }
    }
}
