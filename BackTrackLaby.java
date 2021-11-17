import java.util.ArrayList;
public class BackTrackLaby {

   public static int labRow = 0;
   public static int labCol = 0;
   public static boolean[][] alreadyBeenHere;
   public ArrayList<int[]> solution = new ArrayList<int[]>();
   public static BackTrackLaby btl = new BackTrackLaby();

   public static void main(String[] args) {
       int row = Integer.parseInt(args[0]);
       int col = Integer.parseInt(args[1]);
       labRow = row;
       labCol = col;
       Labyrinth l = new Labyrinth(labRow, labCol);
       alreadyBeenHere = new boolean[labRow][labCol];
       btl.solve(l);
    }
    
    public int[][] solve(Labyrinth l) {
        findSafeMove(0, 0, l);
        int[][] solutionArray = solution.toArray(new int[solution.size()][2]);
        return solutionArray;
    }
    
    public boolean isASafeMove(int row, int col, int[] x, Labyrinth l) {
        return (l.isValid(row + x[0], col + x[1]) && l.isStone(row + x[0], col + x[1]) && !alreadyBeenHere[row + x[0]][col + x[1]]);
    }
    
    public void makeMove(int[] x) {
        solution.add(x);
    }
    
    public void undoMove(int[] x) {
        solution.remove(solution.size() - 1);
    }
    
    public void findSafeMove(int row, int col, Labyrinth l) {
        if (row == labRow - 1 && col == labCol - 1) {
            
            return;
        } 
        for (int[] x : new int[][] {Labyrinth.UP, Labyrinth.DOWN, Labyrinth.LEFT, Labyrinth.RIGHT}) {
            if (isASafeMove(row, col, x, l)) {
                makeMove(x);
                findSafeMove(row + x[0], col + x[1], l);
                undoMove(x);
            }
        }
    }
}
