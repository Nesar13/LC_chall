import java.util.ArrayList;
import java.util.List;

public class Lc94_BinaryTreeInorder_M {

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return list;

        helper(root);
        return list;
    }
public void helper(TreeNode root) {


    inorderTraversal(root.left);
    list.add(root.val);
    inorderTraversal((root.right));

}
    public static void main(String[] args) {

    }
}



