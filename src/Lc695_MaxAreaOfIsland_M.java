public class Lc695_MaxAreaOfIsland_M {

    public static int max = 0;
    public static int temp = 0;

    public static int maxAreaOfIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    helper(grid, i, j);
                    temp = 0;
                }

            }

        }
        return max;
    }


    public static void helper(int[][] g, int i, int j) {
        if (i < 0 || i > g.length - 1 || j < 0 || j > g[i].length - 1 || g[i][j] == 0) return;

        temp++;
        max = Math.max(max, temp);
        g[i][j] = 0;

        helper(g, i - 1, j);
        helper(g, i + 1, j);
        helper(g, i, j + 1);
        helper(g, i, j - 1);


    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        System.out.println(maxAreaOfIsland(grid));
    }
}
