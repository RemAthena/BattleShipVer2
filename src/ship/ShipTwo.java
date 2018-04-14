package ship;

public class ShipTwo extends Ship {
    private final int SIZE = 2;

    // Constructor
    public ShipTwo(){
        length = SIZE;
        wasHit = new boolean[SIZE];
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        return wasHit[0] & wasHit[1];
    }
}
