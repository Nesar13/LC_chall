import java.util.Arrays;

public class Lc687_LongestUnivaluePath_M {

    private static int res=0;
    public static int longestUnivaluePath(TreeNode root) {



        int [] dummy=helper(root);

        return res;

    }
    // temp will have [edges, valueToCompare]
    private static int[] helper(TreeNode root) {

        if (root == null){

        return new int[]{0, -9000};
    }
        if(root.left == null && root.right==null) {
            return new int[] {0, root.val};
        }



        int[] left= helper(root.left);
        int[] right=helper(root.right);

        System.out.println("left: "+ Arrays.toString(left));
        System.out.println("right: "+ Arrays.toString(right));
        System.out.println("root: "+ root.val);
int currMaxEdge=0;
int curValue=0;
        if (root.val==left[1] && root.val==right[1]){ currMaxEdge =Math.max(left[0], right[0])+ 2; }

        else if(root.val==left[1] || root.val==right[1]) {
            currMaxEdge =Math.max(left[0], right[0])+ 1;

           curValue=root.val;
        }
        else {

            curValue= root.val;

        }

        res= Math.max(res, currMaxEdge);

        System.out.println(Arrays.toString(new int[]{currMaxEdge, curValue}));

        return new int[] {currMaxEdge, curValue};




    }
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);

       // root.left=new TreeNode(1);
       /* root.left=new TreeNode(4);
        root.right=new TreeNode(5);

        root.right.right=new TreeNode(5);

        root.left.left=new TreeNode(4);

        root.left.right=new TreeNode(4);*/

        System.out.println(longestUnivaluePath(root));

    }
}
