import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LC_chall {

public static int[] twoSum(int[] nums, int target){
    Map<Integer, Integer> map=new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement=target-nums[i];
        if (map.containsKey(complement)){
            return new int[] {map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}


    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] some= {1, 2, 3, 4};
        int target= 6;
//        System.out.println(Arrays.toString((twoSum(some, target))));
//        ListNode l1= new ListNode(1);
//        l1.next= new ListNode(2);
//        l1.next.next=new ListNode(3);
//        l1.next.next.next=new ListNode (4);
//        l1.next.next.next.next=new ListNode (5);

//        ListNode l2 =new ListNode (9);
//        l2.next =new ListNode (2);
//        System.out.println(l1);
////        System.out.println(l2);
//        System.out.println(removeNthFromEnd(l1, 1));
   Node root=new Node(3);
   root.children.add(new  Node (4));
   root.children.add(new Node(5));
   root.children.add(new Node(6));
   root.children.get(0).children.add(new Node (2));
   root.children.get(0).children.add(new Node (8));


        System.out.println(root);


//   n.children= new List<Node> ;



        System.out.println(root);




    }


    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    };


}
