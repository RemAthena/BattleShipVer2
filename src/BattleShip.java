import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Sea mySea = new Sea();
        mySea.showYourGrid();
        System.out.println();
        mySea.showMyGrid();
        while(!mySea.checkWin()) {
            System.out.print("Please enter the row number you want to shot (must be from 1 to 10):");
            int x = scan.nextInt() - 1;
            while (x < 0 || x > 9) {
                System.out.print("The row number must be from 1 to 10. Please re-enter:");
                x = scan.nextInt() - 1;
            }
            System.out.print("Please enter the column number you want to shot (must be from A to J):");
            int y = scan.next().toUpperCase().charAt(0) - 'A';
            while (y < 0 || y > 9) {
                System.out.print("The column number must be from A to J. Please re-enter:");
                y = scan.next().toUpperCase().charAt(0) - 'A';
            }
            mySea.shot(x, y);
        }
    }
}
