import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> closeMap = new HashMap<Character, Character>();
        closeMap.put(')', '(');
        closeMap.put(']', '[');
        closeMap.put('}', '{');

        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(closeMap.containsKey(character)){
                if(!stack.isEmpty() && stack.peek() == closeMap.get(character))
                    stack.pop();
                else
                    return false;
            }
            else
                stack.push(character);
        }
        return stack.isEmpty();
    }
}