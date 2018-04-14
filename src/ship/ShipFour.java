package ship;

public class ShipFour extends Ship {
    private final int SIZE = 4;

    // Constructor
    public ShipFour(){
        length = SIZE;
        wasHit = new boolean[SIZE];
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        return wasHit[0] & wasHit[1] & wasHit[2] & wasHit[3];
    }
}
