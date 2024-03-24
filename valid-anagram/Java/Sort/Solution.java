import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // method 2 sort then compare time: O(S + T), memory: O(1)? Maybe? 
        // Interviewer for some reason think sorted don't take extra memory
        return sortString(s).equals(sortString(t));
    }
    private String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}