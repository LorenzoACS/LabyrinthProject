import java.util.Random;
public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    // public final int[] UP = {-1,0};
    // public final int[] DOWN = {1,0};
    // public final int[] LEFT = {0,-1};
    // public final int[] RIGHT = {0,1};
    // public int[][] allDirections;
    public static boolean[][] boardOfMaze;
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        mazeRow = row;
        mazeCol = col;
        boardOfMaze = new boolean[mazeRow][mazeCol];
        maze.mazeMove(0, 0);
    }
    
    public void createMaze() {
        for (int i = 0; i < mazeRow; i++) {
            for (int j = 0; j < mazeCol; j++) {
                if (boardOfMaze[i][j]) {
                    System.out.print("S" + " ");
                } else {
                    System.out.print("L" + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void mazeMove(int row, int col) {
        if (boardOfMaze[row][col] == boardOfMaze[mazeRow - 1][mazeCol - 1] && row != 0 && col != 0 ) {
            System.out.println("Random maze generation completed.");
            maze.createMaze();
            return;
        }
        int randomDirectionChooser = (int) Math.random() * 4;
        if (randomDirectionChooser == 0) {
            System.out.print("Here");
            System.out.print(safeMove(row, col, randomDirectionChooser));
            if (safeMove(row, col, randomDirectionChooser)) {
                System.out.print(safeMove(row, col, randomDirectionChooser));
                System.out.print("Before");
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row - 1, col);
                System.out.print("After");
            }
        }
        if (randomDirectionChooser == 1) {
            if (safeMove(row, col, randomDirectionChooser)) {
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row + 1, col);
            }
        }
        if (randomDirectionChooser == 2) {
            if (safeMove(row, col, randomDirectionChooser)) {
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row, col - 1);
            }
        }
        if (randomDirectionChooser == 3) {
            if (safeMove(row, col, randomDirectionChooser)) {
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row, col + 1);
            }
        }
    }
    
    public boolean safeMove(int row, int col, int direction) {
        if (direction == 0) {
            return row - 1 >= 0 && row - 1 < mazeRow && col < mazeCol;
        }
        if (direction == 1) {
            return row + 1 < mazeRow && col < mazeCol;
        }
        if (direction == 2) {
            return row < mazeRow && col >= 0 && col - 1 < mazeCol;
        }
        if (direction == 3) {
            return row < mazeRow && col + 1 < mazeCol;
        } 
        return false; 
    }
    
    public void makeMove(int row, int col, int direction) {
        if (direction == 0) {
            boardOfMaze[row - 1][col] = true;
        }
        if (direction == 1) {
            boardOfMaze[row + 1][col] = true;
        }
        if (direction == 2) {
            boardOfMaze[row][col - 1] = true;
        }
        if (direction == 3) {
            boardOfMaze[row][col + 1] = true;
        } 
    }
}