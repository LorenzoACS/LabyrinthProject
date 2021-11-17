public class BackTrackLaby {
    public static int labSize = 0;
    public static Labyrinth l = new Labyrinth(labSize, labSize);
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        labSize = n;
    }
    public boolean isValidMove() {
        for (int i = 0; i < labSize; i++) {
            for (int j = 0; j < labSize; j++) {
                if (l.isValid(i, j)) {
                    return (l.isStone(i, j + 1) || l.isStone(i + 1, j) || l.isStone(i, j - 1) || l.isStone(i - 1, j));
                } else {
                    return false;
                }
            }
        }
    }
    
    // public boolean horizontalMove(int row, int col) {
        // int row2 = row;
        // int col2 = col;
        // while (l.isValid(row, col)) {
            // if (l.isStone(row, col)) {
                // return true;
            // } else {
                // return false;
            // }
            // col++;
        // }
        // while (l.isValid(row2, col2)) {
            // if (l.isStone(row2, col2)) {
                // return true;
            // } else {
                // return false;
            // }
            // col2--;
        // }
    // }
    // public boolean horizontalMove(int row, int col) {
        // int row2 = row;
        // int col2 = col;
        // while (l.isValid(row, col)) {
            // if (l.isStone(row, col)) {
                // return true;
            // } else {
                // return false;
            // }
            // row++;
        // }
        // while (l.isValid(row2, col2)) {
            // if (l.isStone(row2, col2)) {
                // return true;
            // } else {
                // return false;
            // }
            // row--;
        // }
    // }
    
    // public void findSafeMode(int row) {
        // if (row == labSize) {
            // return;
        // }
        
        // for (int col = 0; col < labSize; col++) {
            // if (isValidMove(row, col)) {
                
            // }
        // }
    // }
}