import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char l = 0;
        var set = new HashSet<Character>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            result = Math.max(result, r-l+1);
        }

        return result;
        
    }
}