import ship.Ship;

public class Ocean {
    private Ship[][] ships;

    // Constructor
    public Ocean(){
        ships = new Ship[10][10];
        placeAllShipsRandomly();
    }

    // public or private?
    public void placeAllShipsRandomly() {
        // TODO
    }

    public boolean isGameOver() {
        // TODO
        return false;
    }

    public void print() {

    }

    private boolean checkValid(int row, int col){
        // TODO
        return true;
    }
}
