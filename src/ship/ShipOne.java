package ship;

public class ShipOne extends Ship {
    private final int SIZE = 1;

    // Constructor
    public  ShipOne() {
        length = SIZE;
        wasHit = new boolean[SIZE];
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        return wasHit[0];
    }
}
