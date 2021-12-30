# 301. Remove Invalid Parentheses
# https://leetcode.com/problems/remove-invalid-parentheses/

# Logic: We create a tree. The tree is such that at every level we remove one charater from the parent. 
# We do level order traversal. IF at any level we find a valid string, we stop BFS and dont go forward. 
# At a lower height the removals are minimum hence we can stop there for sure.

# Time Complexity: Exponential (n^n)
# Space Complexity: O(n!)

from collections import deque
class Solution:
    def isValid(self, s):
        count = 0
        
        for i in s:
            if i == '(':
                count += 1
            elif i == ')':
                count -= 1
            
            if count < 0:
                return False
        
        return count == 0
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # Visited
        hashset = set()
        # Output
        res = list()
        # BFS
        q = deque()
        q.append(s)
        
        while q:
            size = len(q)
            
            for _ in range(size):
                cur = q.popleft()

                if self.isValid(cur):
                    res.append(cur)
            
                if len(res) > 0:
                    break

                for i in range(len(cur)):
                    if cur[i] in '()':
                        newStr = "".join(cur[:i] + cur[i+1:])
                    
                        if newStr not in hashset:
                            hashset.add(newStr)
                            q.append(newStr)
        return res