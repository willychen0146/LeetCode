# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        start, end = 1, n
        while(start < end):
            mid = start + (end-start)//2
            if(isBadVersion(mid) == False):
                start = mid+1
            if(isBadVersion(mid) == True):
                end = mid
        return end