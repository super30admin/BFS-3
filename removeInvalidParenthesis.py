# // Time Complexity :O(2^n) 
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

# Bfs
from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if s == None or len(s)== 0:
            return result

        q = deque()                                     # A queue to store strings
        q.append(s)
        
        hset = set()                                    # avoid duplicate processing
        hset.add(s)


        def isValid(s):                                 # basic function to check if ()()()() is valid
            count = 0
            for i in s:
                if i == "(":
                    count+=1
                if i == ")":
                    count -=1
                if count < 0:
                    return False
            return count == 0
            
        flag = False
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if isValid(curr):
                    result.append(curr)                            # append result till you find the right level
                    flag = True                                     
                
                if flag:                                           # once the flag is true; we wont search for a lower level     
                    continue


                for k in range(len(curr)):

                    if curr[k].isalpha():                           # ignore alphabets
                        continue

                    baby = curr[:k] + curr[k+1:]                    # cur[]ent

                    if baby not in hset:
                        hset.add(baby)
                        q.append(baby)                              # No need to append to queue if its already used
        return result