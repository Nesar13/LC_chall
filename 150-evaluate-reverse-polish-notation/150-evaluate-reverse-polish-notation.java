class Solution {
   public int evalRPN(String[] tokens) {
        //Input: tokens = ["2","1","+","3","*"]
        //Output: 9
        //Explanation: ((2 + 1) * 3) = 9
        
        Deque<String> s = new ArrayDeque<>();
        //add to stack
        // if idex is +, -, *, /  pop twice before it in order and apply operation'
       
        // apply operator to first (+, -,/,*) second
        for(int i= 0; i< tokens.length; i++) {
            
            String temp=tokens[i]; 
            int first=0; 
            int second=0; 
            if (temp.equals("+") || temp.equals("*") || temp.equals("/") || temp.equals("-")){
                 second=Integer.parseInt(s.pop());
                 first = Integer.parseInt(s.pop());
            }
            if(temp.equals("+"))   s.push(String.valueOf(first + second ));
            else if(temp.equals( "-"))  s.push(String.valueOf(first - second ));
            else if(temp.equals("*"))  s.push(String.valueOf(first * second ));
            else if (temp.equals( "/"))  s.push(String.valueOf(first/second ));
            else  s.push(tokens[i]);
        }
         return Integer.parseInt(s.pop());
    }
}