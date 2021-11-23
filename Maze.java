import java.util.Random;
public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    public final int[] UP = {-1,0};
    public final int[] DOWN = {1,0};
    public final int[] LEFT = {0,-1};
    public final int[] RIGHT = {0,1};
    public int[][] allDirections;
    public static boolean[][] boardOfMaze;
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        mazeRow = row;
        mazeCol = col;
        boardOfMaze = new boolean[mazeRow][mazeCol];
        maze.mazeMove(0, 0);
        maze.createMaze();
    }
    
    public void createMaze() {
        for (int i = 0; i < mazeRow; i++) {
            for (int j = 0; j < mazeCol; j++) {
                if (boardOfMaze[i][j]) {
                    System.out.print("S" + "");
                } else {
                    System.out.print("L" + "");
                }
            }
            System.out.println();
        }
    }
    
    public void mazeMove(int row, int col) {
        allDirections = new int[][] {UP, DOWN, LEFT, RIGHT};
        int randomDirectionChooser = (int) Math.random() * 4;
        System.out.println(allDirections[0][0]);
        System.out.println(allDirections[1][0]);
        System.out.println(allDirections[2][0]);
        System.out.println(allDirections[3][0]);
        if (allDirections[randomDirectionChooser][0] == -1 && randomDirectionChooser == 0) {
            if (safeMove(row, col, randomDirectionChooser)) {
                boardOfMaze[row - 1][col] = true;
                mazeMove(row - 1, col);
            }
        }
        if (allDirections[randomDirectionChooser][0] == 1 && randomDirectionChooser == 1) {
            if (safeMove(row, col, randomDirectionChooser)) {
                boardOfMaze[row + 1][col] = true;
                mazeMove(row + 1, col);
            }
        }
        if (allDirections[randomDirectionChooser][0] == 0 && randomDirectionChooser == 2) {
            if (safeMove(row, col, randomDirectionChooser)) {
                boardOfMaze[row][col - 1] = true;
                mazeMove(row, col - 1);
            }
        }
        if (allDirections[randomDirectionChooser][0] == 0 && randomDirectionChooser == 3) {
            if (safeMove(row, col, randomDirectionChooser)) {
                boardOfMaze[row][col + 1] = true;
                mazeMove(row, col + 1);
            }
        }
    }
    
    public boolean safeMove(int row, int col, int direction) {
        if (direction == 0) {
            return row - 1 < mazeRow && col < mazeCol;
        }
        if (direction == 1) {
            return row + 1 < mazeRow && col < mazeCol;
        }
        if (direction == 2) {
            return row < mazeRow && col - 1 < mazeCol;
        }
        if (direction == 3) {
            return row < mazeRow && col + 1 < mazeCol;
        } 
        return false; 
    }
}