import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc102_BinaryTreeLevelOrder_M {
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


        }


        }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List <Integer> temp = new ArrayList<>();

        helper(root, res, temp, 0);

        return res;

    }

    private static  void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int level) {

        if (root==null){ return; }

        if(level > res.size()){ res.add(new ArrayList<>());}

        temp.add(root.val);
        helper(root.left, res, temp, level++);

        helper(root.right, res, new ArrayList<>(), level++);

        res.add(new ArrayList<>(temp));






    }

// use a helper function and specifying the depth
    // we use this depth to add it in our list of list by using it as an index
    // if depth is equal to the the size of the list, then add a new sublist
    // use preorder traversal for this DFS
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public  static void levelHelper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        // add a new list if we exceed  size of the list
        if (depth >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        // get the indexed list, denoted by depth, and add to that sublist
        res.get(depth).add(root.val);
        levelHelper(res, root.left, depth+1);
        levelHelper(res, root.right, depth+1);
    }

    public static List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }



        public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        head.left=new TreeNode(9);
        head.right=new TreeNode(20);
        head.right.left=new TreeNode(15);
        head.right.right=new TreeNode(7);


            System.out.println(levelOrder3(head));



    }
}
