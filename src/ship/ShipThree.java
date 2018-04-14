package ship;

public class ShipThree extends Ship {
    private final int SIZE = 3;

    // Constructor
    public ShipThree(){
        length = SIZE;
        wasHit = new boolean[SIZE];
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        return wasHit[0] & wasHit[1] & wasHit[2];
    }
}
