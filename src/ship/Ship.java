package ship;

public abstract class Ship {
    boolean horizontal;
    int length;
    int row;
    int col;
    boolean[] wasHit;

    // Constructor
    public Ship(final int SIZE){
        this.length = SIZE;
        this.wasHit = new boolean[SIZE];
    }

    // Setter
    public void setHorizontal(boolean horizontal){
        this.horizontal = horizontal;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
    // To set a part of the ship to be hit.
    public abstract void setWasHit(int index, boolean wasHit);

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

    /**
     * Using for Ocean.cheat() function.
     * @return The state symbol of each cell.
     *          0 for no ship, 1 for having a ship
     */
    @Override
    public String toString() {
        if(!this.isShip()) {
            return "0 ";
        }
        else {
            return "1 ";
        }
    }

    /**
     * Using for Ocean.print() function to print the matrix
     *
     * @param x, the row number of the matrix
     * @param y, the column number of the matrix
     * @return  The state symbol of each cell
     *           * for fired but missed. X for hit. O for have not fire
     */
    public String toString(int x, int y) {
        if(!this.isShip() && this.isSunk()){
            return "* ";
        }
        else if(this.isShip() && wasHit[x-row+y-col]) {
            return "X ";
        }
        else {
            return "O ";
        }
    }
}
