# Time Complexity : O(2^N)
# Space Complexity : O(2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# INITIAL SOLUTION USING QUEUE AND HASHSET (NEEDS OPTIMIZATION)

from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s == None or len(s) == 0:
            return [""]
        
        queue = deque()
        visited = set()
        
        queue.append(s)
        shouldExploreFurther = True
        result = []
        while queue:
            levelCount = len(queue)
            for i in range(levelCount):
                element = queue.popleft()
                if element not in visited:
                    if self.isValid(element):
                        shouldExploreFurther = False
                        result.append(element)
                    visited.add(element)
                    if shouldExploreFurther:
                        for j in range(len(element)):
                            if not element[j].isalpha():
                                queue.append(element[:j]+element[j+1:])
                                     
        return result
                
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count +=1
            if s[i] == ')':
                count -=1
            if count <0:
                return False
        
        return count == 0
        
        
        
        