import java.util.Arrays;

public class Lc289_GameOfLife_M {


        //O(MxN) time and space
        public static void gameOfLife(int[][] board) {

            // Neighbors array to find 8 neighboring cells for a given cell
            // you can essentially check all neighbors(including diagonals)
            int[] neighbors = {0, 1, -1};

            int rows = board.length;
            int cols = board[0].length;

            // Create a copy of the original board
            int[][] copyBoard = new int[rows][cols];

            // Create a copy of the original board
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    copyBoard[row][col] = board[row][col];
                }
            }

            // Iterate through board cell by cell.
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    // For each cell count the number of live neighbors.
                    int liveNeighbors = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            // checking each neighbors since the movements boils down to {0,1,-1}
                            if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                                int r = (row + neighbors[i]);
                                int c = (col + neighbors[j]);

                                // Check the validity of the neighboring cell.
                                // and whether it was originally a live cell.
                                // The evaluation is done against the copy, since that is never updated.
                                if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                    liveNeighbors += 1;
                                }
                            }
                        }
                    }

                    // Rule 1 or Rule 3
                    if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        board[row][col] = 0;
                    }
                    // Rule 4
                    if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                        board[row][col] = 1;
                    }
                }
            }
        }
        // this is O(1) space
    // better solution as this does not take extra memory
    // uses -1  to indicate that cell went from live (1) to dead (0)
    // uses 2 to indicate a cell that went from 0 to 1
        public void gameOfLife2(int[][] board) {

            // Neighbors array to find 8 neighboring cells for a given cell
            int[] neighbors = {0, 1, -1};

            int rows = board.length;
            int cols = board[0].length;

            // Iterate through board cell by cell.
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    // For each cell count the number of live neighbors.
                    int liveNeighbors = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {

                            if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                                int r = (row + neighbors[i]);
                                int c = (col + neighbors[j]);

                                // Check the validity of the neighboring cell.
                                // and whether it was originally a live cell.
                                if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                    liveNeighbors += 1;
                                }
                            }
                        }
                    }

                    // Rule 1 or Rule 3
                    if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        // -1 signifies the cell is now dead but originally was live.
                        board[row][col] = -1;
                    }
                    // Rule 4
                    if (board[row][col] == 0 && liveNeighbors == 3) {
                        // 2 signifies the cell is now live but was originally dead.
                        board[row][col] = 2;
                    }
                }
            }

            // Get the final representation for the newly updated board.
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] > 0) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }


    public static void main(String[] args) {
int [][] arr=
        {{0,1,0},
        {0,0,1},
        {1,1,1},
        {0,0,0}};

// not sure why there is a difference in the array

        gameOfLife(arr);


        System.out.println(Arrays.deepToString(arr));


    }
}
