"""
Approach: BFS
TC: O(2 ^ n) --> since you chosing each char to either remove or not. Can also be O(n^n)
SC: O(n)
"""
from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        q = deque()
        set_ = set()
        q.append(s)
        stop_flag = False
        while q and not stop_flag:
            size = len(q)
            for c in range(size):
                curr = q[c]
                if self.isValid(curr):
                    stop_flag = True
                    result.append(curr)
                else:
                    if not stop_flag: # stop processing childen of valid strings
                        for i in range(len(curr)):
                            char = curr[i]
                            if char.isalpha():
                                continue
                            candidate = curr[:i] + curr[i+1:]
                            if candidate not in set_: # do not process same strings
                                q.append(candidate)
                                set_.add(candidate)
        return result
    
    def isValid(self, s):
        count = 0
        for char in s:
            if char == ')':
                if count == 0: return False
                count -= 1
            elif char == '(':
                count += 1
        return count == 0
        