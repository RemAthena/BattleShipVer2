package ship;

public class ShipThree extends Ship {
    private static final int SIZE = 3;

    // Constructor
    public ShipThree(){
        super(SIZE);
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        boolean isSunken = true;
        for(int i = 0; i < length; i++){
            isSunken &= wasHit[i];
        }
        return isSunken;
    }

    public boolean isShip(){
        return true;
    }
}
