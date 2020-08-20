import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc118_PascalTriangle {

//Dynamic programming solution

    public static List<List<Integer>> generate(int rows) {
        List<List<Integer>> result = new ArrayList<>();
        if (rows == 0)
            return result;
        for (int i = 0; i < rows; i++) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            for (int j = 1; j < i + 1; j++) {
                System.out.println("\n row i,j: " + i + ", " + j + " ------------------------");
                System.out.println("1. size-1: " + (ans.size() - 1));
                System.out.println("2. get(size-1): " + (ans.get(ans.size() - 1)));
                System.out.println("3. (i-j+1)/j: " + (i - j + 1) / j);
                System.out.println("4. (size) * (i-j+1)/j): " + ((ans.get(ans.size() - 1)) * (i - j + 1) / j));
                ans.add(ans.get(ans.size() - 1) * (i - j + 1) / j);
                System.out.println("5. list: " + ans);
            }
            result.add(ans);
        }
        return result;
    }


    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            System.out.println(triangle.get(rowNum - 1));
            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static List<List<Integer>> generate3(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());

        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> prevRow = triangle.get(rowNum - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 0; j < rowNum - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            triangle.add(row);


        }
        return triangle;

    }

    public static void main(String[] args) {


        System.out.println(generate3(5));
    }
}
