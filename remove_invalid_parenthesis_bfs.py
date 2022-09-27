# Time Complexity : O(N*N) where is N is number of total parenthesis in the string
# Space Complexity : O(N)  where is N is number of total parenthesis in the string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s == None or s == '':
            return []
        
        result = []
        
        q = deque()
        combinationSet = set()
        q.appendleft(s)
        combinationSet.add(s)
        flag = False
        while(len(q) > 0 and flag != True):
            size = len(q)
            for _ in range(size):
                curr = q.pop()
                if self.checkValidOrNot(curr):
                    result.append(curr)
                    flag = True
                if flag == False:
                    for j in range(len(curr)):
                        if curr[j].isalpha():
                            continue
                        child = curr[:j] + curr[j+1:]
                        if child not in combinationSet:
                            q.appendleft(child)
                            combinationSet.add(child)
                
        return result
        
        
    def checkValidOrNot(self, s):
        count = 0
        for c in s:
            if c.isalpha():
                continue
            if c == '(':
                count += 1
            else:
                if count == 0:
                    return False
                count -= 1
                
        return count == 0
        
    
    
    