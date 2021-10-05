"""
Time Complexity : O(2^N) where N is the length of the string
Space Complexity : O(N) where N is the length of the string
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s) == 0:
            return []
        result = []
        q = deque([])
        hashSet = set()
        q.append(s)
        hashSet.add(s)
        found = False
        # We perform a BFS on the strings and find the substring or baby strings and 
        # add it to the queue. Whenever we find a valid string we set the found flag
        # to true and add the string to the result array
        while q and not found:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if self.isValid(curr):
                    found = True
                    result.append(curr)
                elif not found:
                    for j in range(len(curr)):
                        baby = curr[0:j] + curr[j+1:]
                        if baby not in hashSet:
                            q.append(baby)
                            hashSet.add(baby)
        return result
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            c = s[i]
            if c == ")":
                if count == 0: return False
                count -= 1
            elif c == "(":
                count += 1
        return count == 0