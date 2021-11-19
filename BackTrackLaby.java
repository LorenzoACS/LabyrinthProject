import java.util.ArrayList;
public class BackTrackLaby {

   public static int labRow;
   public static int labCol;
   public static boolean[][] alreadyBeenHere;
   public static int[][] solutionArray; 
   public static ArrayList<int[]> solution = new ArrayList<int[]>();
   public static BackTrackLaby btl = new BackTrackLaby();

   public static void main(String[] args) {
       int row = Integer.parseInt(args[0]);
       int col = Integer.parseInt(args[1]);
       labRow = row;
       labCol = col;
       Labyrinth l = new Labyrinth(labRow, labCol);
       alreadyBeenHere = new boolean[labRow][labCol];
       alreadyBeenHere[0][0] = true;
       l.printGrid();
       System.out.println("\n" + l.solves(btl.solve(l)));
       l.printGrid();
    }
    
    public int[][] solve(Labyrinth l) {
        findSafeMove(0, 0, l);
        solutionArray = solution.toArray(new int[solution.size()][2]);
        for (int i = 0; i < solution.size(); i++) {
            if (solution.get(i) == Labyrinth.UP) {
                    System.out.println(0);
                } else if (solution.get(i) == Labyrinth.DOWN) {
                    System.out.println(1);
                } else if (solution.get(i) == Labyrinth.LEFT) {
                    System.out.println(2);
                } else if (solution.get(i) == Labyrinth.RIGHT) {
                    System.out.println(3);
                }
        }
        return solutionArray;
    }
    
    public boolean isASafeMove(int row, int col, int[] x, Labyrinth l) {
        return (l.isValid(row + x[0], col + x[1]) && l.isStone(row + x[0], col + x[1]) && !alreadyBeenHere[row + x[0]][col + x[1]]);
    }

    public void findSafeMove(int row, int col, Labyrinth l) {
        if (row == labRow - 1 && col == labCol - 1 && alreadyBeenHere[labRow - 1][labCol - 1]) {
            System.out.println("Done");
            return;
        } 
        for (int[] x : new int[][] {Labyrinth.UP, Labyrinth.DOWN, Labyrinth.LEFT, Labyrinth.RIGHT}) {
            if (isASafeMove(row, col, x, l)) {
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
