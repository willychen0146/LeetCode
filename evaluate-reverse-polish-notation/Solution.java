import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                numStack.push(numStack.pop() + numStack.pop());
            }
            else if(token.equals("-")){
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 - num2);
            }
            else if(token.equals("/")){
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 / num2);
            }
            else if(token.equals("*")){
                numStack.push(numStack.pop() * numStack.pop());
            }
            else{
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }
}