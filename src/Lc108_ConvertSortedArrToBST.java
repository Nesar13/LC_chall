public class Lc108_ConvertSortedArrToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }



        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;}

            @Override
            public String toString() {
                return "TreeNode{" +
                        "val=" + val +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }


    }

    /**
     * Recursively add treeNode
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static TreeNode buildTree(int[]arr, int start, int end)
    {
        if(start>end)
            return null;

        int mid = (start + end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        //note that start is 0 here
        node.left = buildTree(arr,start,mid-1);
        //note that start = mid+1
        node.right=buildTree(arr,mid+1,end);

        return node;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        TreeNode root = buildTree(nums,0,len-1);
        return root;
    }
    public static void main(String[] args) {
        int[] arr={-10,-3,0,5,9};

        /*System.out.println(sortedArrayToBST(arr));*/
    }


}
