import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        // method 1
        // int longest = 0;
        // int cardinalNum = 0;
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //      if(map.containsKey(s.charAt(i)) && map.getOrDefault(s.charAt(i), 0) > 0){
        //         map.replace(s.charAt(i), 0);
        //         longest+=2;
        //         cardinalNum--;
        //      }
        //      else{
        //         map.put(s.charAt(i), 1);
        //         cardinalNum++;
        //      }
        // }
        // if(cardinalNum > 0)
        //     return longest+1;
        // else
        //     return longest;

        // method 2
        int[] char_counts = new int[128];
        for(char c : s.toCharArray())
            char_counts[c]++;

        int result = 0;
        for(int char_count : char_counts){
            result += char_count / 2 * 2;
            if(result%2 == 0 && char_count%2 == 1)
                result+=1;
        }
        return result;
    }
}