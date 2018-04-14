package ship;

public abstract class Ship {
    protected boolean horizontal;
    protected int length, row, col;
    protected boolean[] wasHit;

    // Setter
    public void setHorizontal(boolean newHorizontal){
        horizontal = newHorizontal;
    }
    public void setRow(int newRow){
        row = newRow;
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

    // To judge whether the ship is sunken.
    public abstract boolean isSunk();

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
