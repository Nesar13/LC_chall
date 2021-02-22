public class Lc116_PopulatingNextPrtNode_M {
    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public Node connect(Node root) {
        Node res= new Node();

        helper(root);
return root;
    }

    private void helper(Node root) {
        if (root == null) {

          return;
        }
        if (root.left != null) {
             root.left.next= root.right;

        }

        if (root.right != null) {
            // if root has a right side, we will take the left of root.next
            root.right.next = root.next != null ? root.next.left : null;
        }

        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {

        //Input: root = [1,2,3,4,5,6,7]
        //Output: [1,#,2,3,#,4,5,6,7,#]
        //Explanation: Given the above perfect binary tree (Figure A),
        // your function should populate each next pointer to point
        // to its next right node, just like in Figure B. The serialized
        // output is in level order as connected by the next pointers,
        // with '#' signifying the end of each level.
//
    }
}
