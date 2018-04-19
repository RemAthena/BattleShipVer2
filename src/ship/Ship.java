package ship;

public abstract class Ship {
    boolean horizontal;
    int length;
    int row;
    int col;
    boolean[] wasHit;

    // Setter
    public void setHorizontal(boolean newHorizontal){
        horizontal = newHorizontal;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int newCol){
        col = newCol;
    }
    // To set a part of the ship to be hit.
    public abstract void setWasHit(int index, boolean newWasHit);

    // Getter
    public boolean isHorizontal() {
        return horizontal;
    }
    public int getLength(){
        return length;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public boolean[] getWasHit() {
        return wasHit;
    }

    // To judge whether the ship is sunken.
    public abstract boolean isSunk();

    // To judge whether it is a ship or empty ocean
    public abstract boolean isShip();

//    @Override
//    public String toString() {
//        return "";
//    }
}
