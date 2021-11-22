public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        mazeRow = row;
        mazeCol = col;
        maze.createMaze();
    }
    
    public void createMaze() {
        
    }
    
}