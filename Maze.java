/*
* Compile: javac Maze.java 
* Run: java Maze args[0] args[1]
* Created by: Lorenzo Stiavelli
* Last Edited: 11/24/21
*/

/**
*  
*
*/
public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    public int totalMoves = 1;
    public static int totalMovesOfMaze;
    public static boolean[][] boardOfMaze;
    public static boolean noMove = false;
    
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        mazeRow = row;
        mazeCol = col;
        totalMovesOfMaze = mazeRow * mazeCol;
        boardOfMaze = new boolean[mazeRow][mazeCol];
        boardOfMaze[0][0] = true;
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
        if (row == mazeRow - 1 && col == mazeCol - 1 && row != 0 && col != 0) {
            System.out.println("Random maze generation completed.");
            maze.createMaze();
            return;
        }
        int randomDirectionChooser = (int) (Math.random() * 4);
        if (randomDirectionChooser == 0) {
            noMove = true;
            if (safeMove(row, col, randomDirectionChooser)) {
                noMove = false;
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row - 1, col);
            }
        }
        if (randomDirectionChooser == 1) {
            noMove = true;
            if (safeMove(row, col, randomDirectionChooser)) {
                noMove = false;
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row + 1, col);
            }
        }
        if (randomDirectionChooser == 2) {
            noMove = true;
            if (safeMove(row, col, randomDirectionChooser)) {
                noMove = false;
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row, col - 1);
            }
        }
        if (randomDirectionChooser == 3) {
            noMove = true;
            if (safeMove(row, col, randomDirectionChooser)) {
                noMove = false;
                makeMove(row, col, randomDirectionChooser);
                mazeMove(row, col + 1);
            }
        }
        if (noMove) {
            mazeMove(row, col);
        }
    }
    
    public boolean safeMove(int row, int col, int direction) {
        if (direction == 0 && totalMoves > 1 && totalMoves < totalMovesOfMaze && row >= 1) {
            return row - 1 >= 0 && row - 1 < mazeRow && col < mazeCol;
        }
        if (direction == 1) {
            return row + 1 < mazeRow && col < mazeCol;
        }
        if (direction == 2 && totalMoves > 1 && totalMoves < totalMovesOfMaze && col >= 1) {
            return row < mazeRow && col >= 0 && col - 1 < mazeCol;
        }
        if (direction == 3) {
            return row < mazeRow && col + 1 < mazeCol;
        } 
        return false; 
    }
    
    public void makeMove(int row, int col, int direction) {
        if (direction == 0 && totalMoves > 1 && totalMoves < totalMovesOfMaze) {
            boardOfMaze[row - 1][col] = true;
            totalMoves++;
        }
        if (direction == 1) {
            boardOfMaze[row + 1][col] = true;
            totalMoves++;
        }
        if (direction == 2 && totalMoves > 1 && totalMoves < totalMovesOfMaze) {
            boardOfMaze[row][col - 1] = true;
            totalMoves++;
        }
        if (direction == 3) {
            boardOfMaze[row][col + 1] = true;
            totalMoves++;
        } 
    }
}