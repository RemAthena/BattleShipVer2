public class Sea {
    private final int rows = 10, cols = 10;
    private int numHits, totalLength;    //number of hits in total
    private int[][] yourGrid;     //where the ships actually are. player cannot see it
    private char[][] myGrid;      //The grid that the player could see

    public Sea() {
        numHits = 0;
        yourGrid = new int[rows][cols];
        myGrid = new char[rows][cols];
        //initialize the two grids
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                yourGrid[i][j] = 0;
                myGrid[i][j] = 'O';
            }
        }
        //Place ships
        for(int i = 4; i > 0; i--) {    //the length of ship
            for(int j = 4-i; j >= 0; j--){  //how many this kind of ship should be placed
                placeShip(i);
            }
        }
        //to calculate the total length of ships
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (yourGrid[i][j] == 1) {
                    totalLength++;
                }
            }
        }
    }

    //print all the ship on the grid to test
    public void showYourGrid() {
        System.out.println("\tA B C D E F G H I J");    //print the first line
        for(int i = 0; i < rows; i++) {
            System.out.print(i+1 + "\t");   //print the first column
            for(int j = 0; j < cols; j++){
                System.out.print(yourGrid[i][j] + " ");
            }
            System.out. println();
        }
    }

    //print the grid from the player's side
    public void showMyGrid(){
        System.out.println("\tA B C D E F G H I J");    //print the first line
        for(int i = 0; i < rows; i++) {
            System.out.print(i+1 + "\t");   //print the first column
            for(int j = 0; j < cols; j++){
                System.out.print(myGrid[i][j] + " ");
            }
            System.out. println();
        }
    }

    //Check whether player wins.
    public boolean checkWin() {
        if(numHits == totalLength) { //means all ships sink
            System.out.println("Congratulations! You win!");
            return true;
        }
        return false;
    }
    //the player shot a point
    public void shot(int x, int y){
        if(myGrid[x][y] == '*' || myGrid[x][y] == 'X') {
            System.out.println("You have already shot this point.");
        }
//        else if(myGrid[x][y] == '.') {
//            System.out.println("This point must be void");
//        }
        else if(yourGrid[x][y] == 0) {  //miss
            myGrid[x][y] = '*';
            System.out.println("Miss.");
        }
        else if(yourGrid[x][y] == 1) {  //hit
            myGrid[x][y] = 'X';
            numHits++;
            System.out.println("Hit!");
        }
        showYourGrid();
        showMyGrid();
    }

    //Random place ships in the grid
    private void placeShip(int size) {
        if(Math.random()<0.5){  //1/2 probability to be vertical
            int row = (int)(Math.random()*(rows-size)); //generate a random row number. from 0 to 10-size
            int col = (int)(Math.random()*(cols-1));    //generate a random column number. from 0 to 9
            if(checkShip(row, col, size, true)){    //if the select point is valid
                for(int i = row; i < row+size; i++) {   //change 0 to 1. means this point is occupied by a ship
                    yourGrid[i][col] = 1;
                }
            }
            else{
                placeShip(size);    //regenerate the ship
            }
        }
        else{   //1/2 probability to be horizontal
            int row = (int)(Math.random()*(rows-1));    //generate a random row number. from 0 to 9
            int col = (int)(Math.random()*(cols-size)); //generate a random column number. from 0 to 10-size
            if(checkShip(row, col, size, false)){   //if the select point is valid
                for(int i = col; i < col+size; i++) {   //change 0 to 1. means this point is occupied by a ship
                    yourGrid[row][i] = 1;
                }
            }
            else{
                placeShip(size);    //regenerate the ship
            }
        }
    }
    //check whether the ship can be placed
    private boolean checkShip(int x, int y, int size, boolean vertical){
        if(vertical) {  //if the ship is vertically placed
            for(int i = -1; i <= size; i++){    //for each row
                if(x+i < 0 || x+i >= rows){ //if row number(x) is 0 or x+size is 10. Out of boundary
                    continue;
                }
                for(int j = -1; j <= 1; j++){   //for each column
                    if(y+j < 0 || y+j >= cols){ //if column number(y) is 0 or 9. Out of boundary
                        continue;
                    }
                    if(yourGrid[x+i][y+j] != 0){    //if any point is not 0, means the point (x,y) is not valid
                        return false;
                    }
                }
            }
            return true;
        }
        else{   //if the ship is horizontal placed
            for(int i = -1; i <= 1; i++){   //for each row
                if(x+i < 0 || x+i >= rows){ //if row number(x) is 0 or 9. Out of boundary
                    continue;
                }
                for(int j = -1; j <= size; j++){    //for each column
                    if(y+j < 0 || y+j >= cols){ //if column number(y) is 0 or y+size is 10. Out of boundary
                        continue;
                    }
                    if(yourGrid[x+i][y+j] != 0){    //if any point is not 0, means the point (x,y) is not valid
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
