class Solution {
  // the smallest (head) and the largest (prev) nodes
  Node head = null;
  Node prev = null;

  public void helper(Node node) {
    if (node != null) {
      // left
      helper(node.left);
      // node 
      if (prev != null) {
        // link the previous node 
        // with the current one (node)
        prev.right = node;
        node.left = prev;
      }
      else {
        // keep the smallest node
        // to close DLL later on
       head = node;
      }
      prev = node;
      // right
      helper(node.right);
    }
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;

    helper(root);
    // close DLL
    prev.right = head;
    head.left = prev;
    return head;
  }
}