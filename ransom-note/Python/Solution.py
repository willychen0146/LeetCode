class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if(len(ransomNote) > len(magazine)):
            return False
        word = [0] * 26
        for ch in magazine:
            word[ord(ch) - ord('a')] += 1
        for ch in ransomNote:
            if(word[ord(ch) - ord('a')] == 0):
                return False
            word[ord(ch) - ord('a')] -= 1
        return True