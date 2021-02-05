public class Lc200_NumberOfIslands_M {

//    public int numIslands(char[][] grid) {
//    int end=grid.length;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//
//            }
//        }
//
//        return 0;
//    }



        static int rows;          // The height of the given grid
        static int cols;          // The width of the given grid
        static char[][] g;     // The given grid, stored to reduce recursion memory usage

        /**
         * This converts all the 1s and it's adjacent 1s to 0 and then count it as an island
         *
         * Given a 2d grid map of '1's (land) and '0's (water),
         * count the number of islands.
         *
         * This method approaches the problem as one of depth-first connected
         * components search
         * @param grid, the given grid.
         * @return the number of islands.
         */
        public static int numIslands(char[][] grid) {
            // Store the given grid
            // This prevents having to make copies during recursion
            g = grid;

            // Our count to return
            int c = 0;

            // Dimensions of the given graph
            rows = g.length;
            if (rows == 0) return 0;
            cols = g[0].length;

            // Iterate over the entire given grid
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (g[i][j] == '1') {
                        dfs(i, j);
                        c++;
                    }
                }
            }
            return c;
        }

        /**
         * Marks the given site as visited, then checks adjacent sites.
         *
         * Or, Marks the given site as water, if land, then checks adjacent sites.
         *
         * Or, Given one coordinate (i,j) of an island, obliterates the island
         * from the given grid, so that it is not counted again.
         *
         * @param i, the row index of the given grid
         * @param j, the column index of the given grid
         */
        private static void dfs(int i, int j) {

            // Check for invalid indices and for sites that aren't land
            if (i < 0 || i >= rows || j < 0 || j >= cols || g[i][j] != '1')
                return;

            // Mark the site as visited
            g[i][j] = '0';

            // Check all adjacent sites
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }

    public static void main(String[] args) {
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1

        char [][] matrix = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(matrix));

    }
}
