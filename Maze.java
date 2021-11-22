public class Maze {
    public static int mazeRow;
    public static int mazeCol;
    public static Maze maze = new Maze();
    // http://weblog.jamisbuck.org/2011/1/12/maze-generation-recursive-division-algorithm
    // if width < height (horizontal) if height < width (vertical) else choose horizontal or vertical randomly 
    public static void main(String[] args) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        mazeRow = row;
        mazeCol = col;
        maze.createMaze();
    }
    
    public void createMaze() {
        
    }
    
    public void bisectDirection() {
        
    }
    
    public void splitBisects() {
        
    }
    
}