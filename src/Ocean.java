import ship.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The result of fire. It is for return value.
 */
enum fireResult{
    MISS, HIT, ALREADY_FIRED
}

public class Ocean {
    private final int NUM_ROWS = 10;
    private final int NUM_COLS = 10;
    private Ship[][] ships;
    private List<Ship> allShips;    //Use List instead of ArrayList

    /* Constructor */
    public Ocean(){
        ships = new Ship[NUM_ROWS][NUM_COLS];
        allShips = new ArrayList<Ship>();
        initOcean();
    }

    // Getter
    public Ship[][] getShips(){
        return ships;
    }

    /**
     * Place all ships randomly into the ocean.
     */
    public void placeAllShipsRandomly() {
        generateShipFour();
        for(int i = 0; i < 2; i++){
            generateShipThree();
        }
        for(int i = 0; i < 3; i++){
            generateShipTwo();
        }
        for(int i = 0; i < 4; i++){
            generateShipOne();
        }
    }

    /**
     * Generate a ShipFour object and place it into the ocean
     */
    private void generateShipFour() {
        Ship newShip = new ShipFour();
        setAttrAndPlaceShip(newShip);
    }

    /**
     * Generate a ShipThree object and place it into the ocean
     */
    private void generateShipThree(){
        Ship newShip = new ShipThree();
        setAttrAndPlaceShip(newShip);
    }

    /**
     * Generate a ShipTwo object and place it into the ocean
     */
    private void generateShipTwo(){
        Ship newShip = new ShipTwo();
        setAttrAndPlaceShip(newShip);
    }

    /**
     * Generate a ShipOne object and place it into the ocean
     */
    private void generateShipOne(){
        Ship newShip = new ShipOne();
        setAttrAndPlaceShip(newShip);
    }

    /** Set up the attributes of the new ship and place it into the ocean
     * @param newShip   the new generated ship
     */
    private void setAttrAndPlaceShip(Ship newShip){
        do{
            setShipAttr(newShip);
        } while(!isValid(newShip));
        placeShipIntoOcean(newShip);
        allShips.add(newShip);
    }

    /**
     * Initialize the ocean by fill it with EmptyOcean objects
     */
    private void initOcean(){
        for(int i = 0; i < ships.length; i++){
            for(int j = 0; j < ships[0].length; j++){
                ships[i][j] = new EmptyOcean(i, j);
            }
        }
    }

    /**Set up the attributes of the new ship
     * @param newShip   the new generated ship
     */
    private void setShipAttr(Ship newShip){
        boolean newDirection = generateRandomDirection();
        newShip.setHorizontal(newDirection);
        int newRow = generateRandomRow(newShip);
        int newCol = generateRandomCol(newShip);
        newShip.setRow(newRow);
        newShip.setCol(newCol);
    }

    /** Generate a random direction
     * @return  the direction of the ship
     */
    private boolean generateRandomDirection(){
        return Math.random() < 0.5 ? true : false;
    }

    /** Generate a random row number
     * @param newShip   a new generated ship
     * @return  the row number of the ship
     */
    private int generateRandomRow(Ship newShip){
        if(newShip.isHorizontal()){
            return (int)(Math.random()*(NUM_ROWS-1));
        }
        return (int)(Math.random()*(NUM_ROWS-newShip.getLength()));
    }

    /** Generate a random column number
     * @param newShip   a new generated ship
     * @return  the column number of the ship
     */
    private int generateRandomCol(Ship newShip){
        if(newShip.isHorizontal()){
            return (int)(Math.random()*(NUM_COLS-newShip.getLength()));
        }
        return (int)(Math.random()*(NUM_COLS-1));
    }

    /** Check the validation of the new generated ship
     * @param newShip   a new generated ship
     * @return  whether the row and column number is valid or not
     */
    private boolean isValid(Ship newShip){
        for(int i = 0; i < newShip.getLength(); i++){
            if(newShip.isHorizontal() && !isNoShipAround(newShip.getRow(), newShip.getCol() + i)){
                return false;
            }
            else if(!newShip.isHorizontal() && !isNoShipAround(newShip.getRow() + i, newShip.getCol())){
                return false;
            }
        }
        return true;
    }

    /** To check whether there is ship around the particular cell
     * @param row   the row number of the cell
     * @param col   the column number of the cell
     * @return  if there is no ship around the cell, return 1
     */
    private boolean isNoShipAround(int row, int col){
        for(int i = row-1; i <= row+1; i++){
            if(i < 0 || i >= NUM_ROWS){
                continue;   //if it is in the first or last row
            }
            for(int j = col-1; j <= col+1; j++){
                if(j < 0 || j >= NUM_COLS){
                    continue;   //if it is in the first or last column
                }
                if(ships[i][j].isShip()){
                    return false;   //if there is a ship around, return not valid
                }
            }
        }
        return true;
    }

    /** Place the new generated ship into the ocean
     * @param newShip   a new generated ship
     */
    private void placeShipIntoOcean(Ship newShip){
        for(int i = 0; i < newShip.getLength(); i++) {
            if(newShip.isHorizontal()) {
                ships[newShip.getRow()][newShip.getCol() + i] = newShip;
            }
            else{
                ships[newShip.getRow() + i][newShip.getCol()] = newShip;
            }
        }
    }

    /**
     * Fire on the specific point
     * @param row   the number of Row
     * @param col   the number of Column
     * @return  whether it hits or misses
     *          0 for miss
     *          1 for hit
     *          2 for you have already fire on this point
     *          enum {}
     */
    public fireResult fire(int row, int col) {
        int rowDiff = row - ships[row][col].getRow();
        int colDiff = col - ships[row][col].getCol();
        if(!ships[row][col].isShip() && !ships[row][col].getWasHit()[rowDiff+colDiff]){
            ships[row][col].setWasHit(0, true);
            return fireResult.MISS;
        }
        else if(ships[row][col].getWasHit()[rowDiff+colDiff]) {
            return fireResult.ALREADY_FIRED;
        }
        else{
            ships[row][col].setWasHit(rowDiff+colDiff,true);
            return fireResult.HIT;
        }
    }

    /** To check whether the game is over.
     * @return  whether all the ship are sunk
     */
    public boolean isGameOver() {
        for(int i = 0; i < allShips.size(); i++){
            if(!allShips.get(i).isSunk()){
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("\tA B C D E F G H I J");
        for(int i = 0; i < NUM_ROWS; i++){
            System.out.print(i+1 + "\t");
            for(int j = 0; j < NUM_COLS; j++){
                System.out.print(ships[i][j].toString(i, j));
            }
            System.out.println();
        }
    }

    public void cheat() {
        System.out.println("\tA B C D E F G H I J");    //print row number
        for(int i = 0; i < NUM_ROWS; i++){
            System.out.print(i+1 + "\t");   //print column number
            for(int j = 0; j < NUM_COLS; j++){
                System.out.print(ships[i][j].toString());
            }
            System.out.println();
        }
    }
}
