package ship;

public class EmptyOcean extends Ship{
    private final int SIZE = 1;

    // Constructor
    public EmptyOcean(int x, int y){
        this.horizontal = true;
        this.length = SIZE;
        this.row = x;
        this.col = y;
        this.wasHit = new boolean[SIZE];
    }

    // Setter
    public void setWasHit(int index, boolean newWasHit){
        wasHit[index] = newWasHit;
    }

    // Getter
    public boolean isSunk(){
        return wasHit[0];
    }

    public boolean isShip(){
        return false;
    }
}
