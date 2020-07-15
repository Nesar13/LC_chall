import com.sun.source.tree.Tree;

import java.util.*;

public class Lc107_BST_TreeTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;


        }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (root != null) {
                    queue.offer(root);
                    level.add(root.val);
                }
                if (root.left != null) {
                    queue.offer(root.left);

                }
                if (root.right != null) {
                    queue.offer(root.right);
                }

            }
            stack.push(level);

        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;

    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode (20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);


        int [] arr= {4,1,2,1,2};
        System.out.println(levelOrderBottom2(root));
        System.out.println('c'-'a');
        System.out.println(singleNumber(arr));

 /*  root.children.add(new Node (4));
   root.children.add(new Node(5));
   root.children.add(new Node(6));
   root.children.get(0).children.add(new Node (2));
   root.children.get(0).children.add(new Node (8));*/
    }

    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Stack<List<Integer>> levels = new Stack<>();
        if(root != null) {
            nodeQueue.offer(root);
        }
        while(!nodeQueue.isEmpty()) {
            int qSize = nodeQueue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = nodeQueue.poll();
                level.add(curr.val);
                if(curr.left != null) nodeQueue.offer(curr.left);
                if(curr.right != null) nodeQueue.offer(curr.right);
            }
            levels.push(level);
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!levels.isEmpty()) {
            res.add(levels.pop());
        }
        return res;
    }

        public static int singleNumber(int[] nums) {
           HashMap<Integer,Integer> map = new HashMap();
            for (int i = 0; i <nums.length ; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            for (int i = 0; i <nums.length ; i++) {
                if (map.get(nums[i])==1)
                return nums[i];
            }
        return 0;

        }

}



}
