/*
* Compile: javac BackTrackLaby.java
* Run: java BackTrackLaby [row args] [col args]
* Created by: Lorenzo Stiavelli
* Last Edited: 11/19/21
*/

// Import classes.
import java.util.ArrayList;

/**
* This class contains all the variables, fields, and methods needed in order 
* to backtrack through a maze with brute force. It also prints all the moves
* of the solution, allowing users to take a closer look at how it works. 
* It also prints to the user if the maze was solved or not solved by the program.
*/
public class BackTrackLaby {
   public static int labRow;
   public static int labCol;
   public static boolean[][] alreadyBeenHere;
   public static int[][] solutionArray; 
   public static ArrayList<int[]> solution = new ArrayList<int[]>();
   public static BackTrackLaby btl = new BackTrackLaby();
   public int count = 0;
   
   /** 
   * Main method which tells you if the code was able to solve the current maze being referenced. 
   * @param Takes in two args for the row and column of the @Labyrinth ( @labRow and @labCol ).
   * @return Returns nothing ( @void ).
   */ 
   public static void main(String[] args) {
       int row = Integer.parseInt(args[0]);
       int col = Integer.parseInt(args[1]);
       labRow = row;
       labCol = col;
       Labyrinth l = new Labyrinth(labRow, labCol);
       alreadyBeenHere = new boolean[labRow][labCol];
       alreadyBeenHere[0][0] = true;
       // Checks if the solution solved it or not.
       if (l.solves(btl.solve(l))) {
           System.out.println("The program was able to solve the maze.\n" + l.solves(btl.solve(l)));
       } else {
           System.out.println("The program was not able to solve the maze.\n" + l.solves(btl.solve(l)));
       }
       l.printGrid();
    }
    
    /**
    * This method calls the recursive method ( @findSafeMove ) and is 
    * where all the moves of the correct solution are accounted for and 
    * converted into another 2-D array that it returns.
    * @param Takes in a @Labyrinth object ( @l ) 
    * @return Returns a 2-D int array which is then taken by the @solves method of @Labyrinth.
    */
    public int[][] solve(Labyrinth l) {
        findSafeMove(0, 0, l);
        solutionArray = solution.toArray(new int[solution.size()][2]);
        for (int i = 0; i < solution.size(); i++) {
            if (solution.get(i) == Labyrinth.UP) {
                System.out.println("Move " + count + ": " + 0 + ".");
                count++;
            } else if (solution.get(i) == Labyrinth.DOWN) {
                System.out.println("Move " + count + ": " + 1 + ".");
                count++;
            } else if (solution.get(i) == Labyrinth.LEFT) {
                System.out.println("Move " + count + ": " + 2 + ".");
                count++;
            } else if (solution.get(i) == Labyrinth.RIGHT) {
                System.out.println("Move " + count + ": " + 3 + ".");
                count++;
            }
        }
        return solutionArray;
    }
    
    /** 
    * Method which checks if a move is safe or not. Uses methods from
    * @Labyrinth class named @isStone and @isValid. 
    * @param Takes in four parameters: two ints ( @row and @col ), a 1-D int array ( @x ), and a @Labyrinth object ( @l ).
    * @return Returns a boolean value (safe or not safe).
    */
    public boolean isASafeMove(int row, int col, int[] x, Labyrinth l) {
        return (l.isValid(row + x[0], col + x[1]) && l.isStone(row + x[0], col + x[1]) && !alreadyBeenHere[row + x[0]][col + x[1]]);
    }

    /**
    * Method containing the recursive/backtracking algorithm. It will end once 
    * the last tile of the Labyrinth has been visited ( @alreadyBeenHere ).
    * @param Takes in three parameters: two ints ( @row and @col ), and a @Labyrinth object ( @l ).
    * @return Returns nothing ( @void ).
    */
    public void findSafeMove(int row, int col, Labyrinth l) {
        if (row == labRow - 1 && col == labCol - 1 && alreadyBeenHere[labRow - 1][labCol - 1]) {
            System.out.println("Done");
            return;
        } 
        for (int[] x : new int[][] {Labyrinth.UP, Labyrinth.DOWN, Labyrinth.LEFT, Labyrinth.RIGHT}) {
            if (isASafeMove(row, col, x, l)) {
                if (alreadyBeenHere[labRow - 1][labCol - 1]) {
                    break;
                } else {
                    solution.add(x);
                    alreadyBeenHere[row + x[0]][col + x[1]] = true;
                    findSafeMove(row + x[0], col + x[1], l);
                    if (!alreadyBeenHere[labRow - 1][labCol - 1]) {
                    solution.remove(solution.size() - 1);
                    alreadyBeenHere[row + x[0]][col + x[1]] = false;
                    }
                }
            }
        }
    }
}
