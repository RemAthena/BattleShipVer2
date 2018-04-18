import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OceanTest {
    @Test
    public void testGetShips(){
        Ocean ocean = new Ocean();
        assertEquals(10, ocean.getShips().length);
        assertEquals(10, ocean.getShips()[0].length);
    }

    @Test
    public void testPlaceShipOne(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for(int i = 0; i < ocean.getShips().length; i++){
            for(int j = 0; j < ocean.getShips()[0].length; j++){
                if (!ocean.isGameOver()){
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
    public void testPlaceShipTwo(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for(int i = 0; i < ocean.getShips().length; i++){
            for(int j = 0; j < ocean.getShips()[0].length; j++){
                if (!ocean.isGameOver()){
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
    public void testPlaceShipThree(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for(int i = 0; i < ocean.getShips().length; i++){
            for(int j = 0; j < ocean.getShips()[0].length; j++){
                if (!ocean.isGameOver()){
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
    public void testPlaceShipFour(){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        for(int i = 0; i < ocean.getShips().length; i++){
            for(int j = 0; j < ocean.getShips()[0].length; j++){
                if (!ocean.isGameOver()){
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
}
