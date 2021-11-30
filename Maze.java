/*
* Compile: javac Maze.java 
* Run: java Maze args[0] args[1]
* Created by: Lorenzo Stiavelli
* Last Edited: 11/24/21
*/

/**
* This is an additional class to the Labyrinth project. It creates a randomly
* generated labyrinth/maze of stone and lava tiles. There is guaranteed to
* one path to the end/last tile every time.
*/
public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    public int totalMoves = 1;
    public static int totalMovesOfMaze;
    public static boolean[][] boardOfMaze;
    public static boolean noMove = false;
    /**
    * This method gets the values of the row and column for the size of labyrinth/maze and 
    * the boolean 2-D array boardOfMaze.
    * @param args[0] This is the row of the Labyrinth.
    * @param args[1] This is the column of the Labyrinth.
    */
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
    /**
    * This method creates the labyrinth/maze after mazeMove is finished 
    * setting each tile to either true or false for stone or lava.
    */
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
    /**
    * This method is responsible for making the different directional moves
    * It goes through every possible move (up, down, left, right) and will
    * make the move based on if its 0, 1, 2, 3 respectively. 
    * @param row This is the current row on the Labyrinth.
    * @param col This is the current column on the Labyrinth.
    */
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
    /**
    * This method checks if a tile is safe or not. It checks if the next tile
    * is still on the board and does not exceed the total number of possible tiles.
    * @param row The current row on the Labyrinth.
    * @param col The current column on the Labyrinth.
    * @param direction The direction of the current move. 
    * @return boolean If the tile is safe or not.
    */
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
    /**
    * This method is actually responsible for making the tile/move after 
    * every check is passed/true. 
    * @param row The current row in the Labyrinth.
    * @param col The current column in the Labyrinth.
    * @param direction The direction of the current move. 
    */
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