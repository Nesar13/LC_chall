import java.util.List;

public class Lc257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        int count=0;
        List<String> res = null;
        dfs(root, count, res);

    }

    private void dfs(TreeNode root, int count, List<String> res) {
       
    }

    public static void main(String[] args) {
        
    }


}
