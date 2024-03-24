class Solution {
    public boolean isPalindrome(String s) {
        // method: Brute force (time: O(n) + extra memory)
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                newString.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String reversedString = newString.toString();
        String reverse = newString.reverse().toString();
        return reversedString.equals(reverse);
    }
}