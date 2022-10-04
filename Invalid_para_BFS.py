# BFS Approach
# Time complexity : O(2^N)
# Space complexity : O(N)
from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        # check for null case
        if not s or len(s) == 0:
            return res
        
        # maintain a set to avoid duplicates and flag to check for the level (minimum number of removals)
        seen = set(); flag = False
        q = deque([])
        # add the whole string to the queue and set
        q.append(s); seen.add(s)
        
        # we continue the loop until the queue is not empty and flag is False
        while q and not flag:
            # maintain the size of the queue as we are moving level or string length wise
            size = len(q)
            for i in range(size):
              # pop the string from the queue and check if that is a valid string
                curr = q.popleft()
                
                if self.isValid(curr):
                  # if valid, then make the flag as True and append the current string to result
                    flag = True
                    res.append(curr)
                else:
                  # if the flag is not true
                    if not flag:
                      # we do a for loop recursion
                        for j in range(len(curr)):
                          # create subtrings of the current string and check if it is present in the set
                            child = curr[0:j] + curr[j+1:]
                            if child not in seen:
                              # if not present only then add to the queue and set
                                q.append(child)
                                seen.add(child)
        
        return res
    
    # check the validity of the string by counting the opening and closing brackets
    def isValid(self,s):
        count = 0
        for k in range(len(s)):
            if s[k] == '(': 
                count +=1
            else:
                if s[k] == ')':
                  # if we encounter a closing brace and the count is 0, which means this is the first character
                    if count == 0:
                        return False
                    # else decrement the counter
                    count -= 1
        # if at the end, count is 0, then we return true stating that the string is valid
        return count == 0
