import java.util.ArrayList;
import java.util.List;

public class Lc637_AverageOfLevelsInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }}

    public List<Double> averageOfLevels(TreeNode root) {


        double sum=0;
        List<Double> res= new ArrayList<>();
        List<List<Double>> store = new ArrayList<>();

        dfs(root, store, res, 0, 0);

        for (int i = 0; i <store.size() ; i++) {

                res.add(store.get(i).get(store.get(i).size()-1)/store.get(i).size());
            }


        return res;



    }

    private void dfs(TreeNode root, List<List<Double>> store, List<Double> res, int depth, double sum) {

        if(root==null) return;
        if (depth >= store.size() ) {

            store.add(new ArrayList<>());

           /* if (depth > store.size()) {
                res.add(sum/store.get(depth-1).size());
            }*/

        }

        if (depth==store.size()) {sum += root.val;
        store.get(depth).add(sum); }



        dfs(root.left, store, res, depth+1, sum);

        dfs(root.right, store, res , depth+1, sum);


    }

    // using depth first search to keep track of the count of each level in the tree in one list
    // and we sum each level in in another list
    // afterwards, we find the average.
    public static List < Double > averageOfLevels2(TreeNode root) {
        List < Integer > count = new ArrayList < > ();

        List < Double > res = new ArrayList < > ();

        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }


    public static void average(TreeNode root, int depth, List < Double > sum, List < Integer > count) {
        if (root == null)
            return;
        if (depth < sum.size()) {
            // since depth is lower than size, we arrived at a previous depth
            // we want to add the the previous depth index
            sum.set(depth, sum.get(depth) + root.val);

            // we are counting the number of values in that depth so we can eventually find the average
            count.set(depth, count.get(depth) + 1);
        } else {
            sum.add(1.0 * root.val);
            count.add(1);
        }
        average(root.left, depth + 1, sum, count);
        average(root.right, depth + 1, sum, count);
    }

    public static void main(String[] args) {

TreeNode root= new TreeNode(3);

root.left=new TreeNode(9);
root.right=new TreeNode(20);
root.right.left=new TreeNode(15);
root.right.right=new TreeNode(7);

        System.out.println(averageOfLevels2(root));


    }
}
