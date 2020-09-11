import java.util.ArrayList;
import java.util.List;

public class Lc155_MinStack {

    static class MinStack {


        List<Integer> list;
        /** initialize your data structure here. */
        public MinStack() {
            list= new ArrayList<Integer>();
        }

        public void push(int x) {
            list.add(x);

        }

        public void pop() {

            list.remove(list.size()-1);

           }


        public int top() {
         return list.get(list.size()-1);
        }

        public int getMin() {
            int min=Integer.MAX_VALUE;
            for (int i = 0; i <list.size(); i++) {
                min=Math.min(min, list.get(i));
            }

            return min;
        }
    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();

        stack.push(2);
        stack.push(-5);
        stack.push(-1);

        stack.pop();

        System.out.println(stack.getMin());



    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
