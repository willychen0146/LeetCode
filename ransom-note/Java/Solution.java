import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        // method 1: HashMap
        // HashMap<Character, Integer> word = new HashMap<>();
        // HashMap<Character, Integer> target = new HashMap<>();

        // for(int i = 0; i < ransomNote.length(); i++)
        //     target.put(ransomNote.charAt(i), 1 + target.getOrDefault(ransomNote.charAt(i), 0));
        // for(int i = 0; i < magazine.length(); i++)
        //     word.put(magazine.charAt(i), 1 + word.getOrDefault(magazine.charAt(i), 0));

        // for(char i : target.keySet()){
        //     if(!word.containsKey(i))
        //         return false;
        //     else{
        //         if(target.get(i) <= word.get(i))
        //             continue;
        //         else
        //             return false;
        //     }
        // }

        // method 2: Use Unicode values create the array
        int[] word = new int[26]; // Assuming lowercase English letters only

        for (char c : magazine.toCharArray())
            word[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (word[c - 'a'] == 0)
                return false;
            word[c - 'a']--;
        }
        return true;
    }
}