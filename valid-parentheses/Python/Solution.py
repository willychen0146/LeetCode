class Solution:
    def isValid(self, s: str) -> bool:
        closeMap = {
            ')':'(',
            ']':'[',
            '}':'{'
        }
        stack = []

        for i, ch in enumerate(s):
            if(ch not in closeMap):
                stack.append(ch)
                continue
            if not stack or stack[-1] != closeMap[ch]:
                return False
            stack.pop()
        return len(stack) == 0