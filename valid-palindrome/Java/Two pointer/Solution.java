class Solution {
    public boolean isPalindrome(String s) {
        // method: two pointer (time: O(n) + memory O(1))
        int l = 0, r = s.length() - 1; // two pointer
        while(l < r){
            while(l < r && !isAlphaNum(s.charAt(l))){
                l++;
            }
            while(r > l && !isAlphaNum(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isAlphaNum(char c){
        return (int) 'A' <= (int) c && (int) c <= (int) 'Z' ||
               (int) 'a' <= (int) c && (int) c <= (int) 'z' ||
               (int) '0' <= (int) c && (int) c <= (int) '9';
    }
}