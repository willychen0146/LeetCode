import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if(character == '(' || character == '[' || character == '{'){
                stack.push(character);
            }
            else if(character == ')' || character == ']' || character == '}'){
                if (stack.isEmpty()) {
                    return false; // No matching opening symbol in the stack
                }
                char left = stack.pop();
                if (character == ')' && left != '(' || character == ']' && left != '[' || character == '}' && left != '{') {
                    return false; // Mismatched opening and closing symbols
                }
            }
        }
        return stack.isEmpty();
    }
}