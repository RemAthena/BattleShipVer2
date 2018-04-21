import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Ocean ocean = new Ocean();
        rows = ocean.getShips().length;
        cols = ocean.getShips()[0].length;
        ocean.placeAllShipsRandomly();
        ocean.cheat();
        System.out.println();
        ocean.print();
        while(!ocean.isGameOver()) {
            int row = inputRowNum(scan);
            int col = inputColNum(scan);
            fireResult result = ocean.fire(row, col);
            viewFireResult(result);
            ocean.print();
        }
        System.out.println("\nCongratulations! You win!");
    }

    private static int rows;
    private static int cols;

    private static int inputRowNum(Scanner scan){
        System.out.print("Please enter the row number you want to shot (must be from 1 to 10):");
        int row = scan.nextInt() - 1;
        while (row < 0 || row > rows-1) {
            System.out.print("The row number must be from 1 to 10. Please re-enter:");
            row = scan.nextInt() - 1;
        }
        return row;
    }

    private static int inputColNum(Scanner scan){
        System.out.print("Please enter the column number you want to shot (must be from A to J):");
        int col = scan.next().toUpperCase().charAt(0) - 'A';
        while (col < 0 || col > cols-1) {
            System.out.print("The column number must be from A to J. Please re-enter:");
            col = scan.next().toUpperCase().charAt(0) - 'A';
        }
        return col;
    }

    private static void viewFireResult(fireResult result){
        if(result == fireResult.MISS){
            System.out.println("Unfortunately. You missed.");
        }
        else if(result == fireResult.HIT){
            System.out.println("Hooray! You hit a ship");
        }
        else {
            System.out.println("Sorry. You have already fire on this cell.");
        }
    }
}
