public class Lc733_FloodFIll {


    public static void main(String[] args) {

    }

    // use dfs to start at the designated rows and column and check
    // four directions(horizontal and vertical) for any oldColor and replace with newColor
    //
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        // check if
        if (oldColor != newColor) dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int color, int newColor) {
        if (image[row][col] == color) {
            image[row][col] = newColor;
            // making sure we are not out of bounds in the array
            if (row >= 1) dfs(image, row - 1, col, color, newColor);
            if (col >= 1) dfs(image, row, col - 1, color, newColor);
            if (row < image.length - 1) dfs(image, row + 1, col, color, newColor);
            if (col < image[0].length - 1) dfs(image, row, col + 1, color, newColor);
        }
    }
}
