import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // method 1: HashMap time: O(S + T), memory: O(S + T)
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!sMap.get(c).equals(tMap.getOrDefault(c, 0)))
                return false;
        }
        return true;
    }
}