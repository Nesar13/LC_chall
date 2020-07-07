import javax.swing.*;
import java.util.*;


public class LC_chall {


    public int getImportance(List<Employee> employees, int id) {

        Queue <Employee> queue =new LinkedList<>();

        for (int i = 0; i <employees.size(); i++) {
            queue.offer(employees.get(i));
        }
        while (!queue.isEmpty()){

        }

        return id;
    }
    int sol=0;




    public static void main(String[] args) {

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
  /* Node root=new Node(3);*/
   
 /*  root.children.add(new Node (4));
   root.children.add(new Node(5));
   root.children.add(new Node(6));
   root.children.get(0).children.add(new Node (2));
   root.children.get(0).children.add(new Node (8));*/

/*
        System.out.println(maxDepth(root));*/


//   n.children= new List<Node> ;





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


// Definition for Employee.



