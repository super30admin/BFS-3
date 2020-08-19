"""
// Time Complexity : o(n)
// Space Complexity : o(n), queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
from collections import deque
class Solution:
    def is_valid(self, s): #function to check for validity
        ct = 0
        
        for i in s:
            if i == "(":
                ct += 1
                
            elif i ==")":
                ct -= 1
            if ct < 0:
                return False
            
        if ct == 0:
            return True
        return False
    
    def removeInvalidParentheses(self, s: str) -> List[str]:#BFS approach to check for validity at each level, if valid strings found at a level, no need to proceed further
        
        res = []
        
        seen = set()
        
        if not s:
            return [""]
        
        flag = False #flag to keep check if valid string found
        q = deque()
        
        q.append(s)
        
        while q:
            
            cur = q.popleft()
            
            if self.is_valid(cur): #if the current string is valid, add to res and set flag to true, no children of the current string will be added to the queue, as we want the longest valid string, as we go deeper length will only decrease 
                flag = True
                res.append(cur)
            
            if not flag: #if valid string hasnt been found yet
                for i in range(0,len(cur)):# add the children, strings formed by removing each element one by one
                
                    if cur[i].isalpha():
                        continue
                    subs = cur[:i] + cur[i+1:]
                
                    if subs not in seen: #to check for repeatitions
                        seen.add(subs)
                        q.append(subs)
                
        if not res:#no valid string
            return [""]
                    
        return res
            
        
        
        