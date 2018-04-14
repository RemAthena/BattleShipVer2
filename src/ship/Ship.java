package ship;
import java.util.ArrayList;

public class Ship {
    private final int OCEAN_SIZE = 10;
    private boolean horizontal;
    private int length, row, col;
    private ArrayList<Integer> remainingPart;

    // Constructor
    public Ship(int newLength){
        length = newLength;
        horizontal = Math.random() < 0.5 ? true : false;
        row = horizontal ? (int)(Math.random()*(OCEAN_SIZE-1)) : (int)(Math.random()*(OCEAN_SIZE-length));
        col = horizontal ? (int)(Math.random()*(OCEAN_SIZE-length)) : (int)(Math.random()*(OCEAN_SIZE-1));
        remainingPart = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            remainingPart.add(i);
        }
    }

    // Setter
    public void setRow(int newRow){
        row = newRow;
    }
    public void setCol(int newCol){
        col = newCol;
    }

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

    // Given the coordinates, find out which part is hit
    public void hit(int x, int y){
        if(horizontal){
            remainingPart.remove(y-col);
        }
        else{
            remainingPart.remove(x-row);
        }
    }

    // To judge whether the ship is sunken.
    public boolean isSunk(){
        if(remainingPart.isEmpty()){
            System.out.println("Congratulations! You have sunk the ship!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
