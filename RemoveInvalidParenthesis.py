"""
Approach:

One thing to understand here is we need a structure like this 

                    "( ) ( ) ) ( )"
        " ) ( ) ) ( )"   "( ( ) ) ( )"  "( ) ) ) ( )" "( ) ( ) ( )" "( ) ( ) ( )" "( ) ( ) ) )" "( ) ( ) ) ("
        
Here at level 1 we got all the combinations we can get by removing one bracket. From these we need to check if anyone of them is valid or not. If its is that means minimum removal would be one and we only need to add all the valid combinations at that level.

If any valid combination is not found at level 1 then we move on to level 2 where we will check all the valid combinations possible by removing 2 brackets. We need to keep doing this until we hit a level where we find a valid combination and that would be our final level.

We will maintain two data structures. Queue and a hashset
Queue: To add all the combinations at a certain level inside and traverse them all together 
Hashset: It is possible to encounter the same string at a level. So we will maintain a hashset to avoid duplicacy.

Algorithm:
1) Add first string to hashset and queue
2) Repeat step 3) to 6) until queue is not empty or a valid combination is not found
3) Repeat steps from 4) to 6) until the current size of the queue
4) Pop the first string from the queue.
5) If the string is valid add it to the queue and stop adding to the queue any more cobinations of next level
6) If string is not valid then add all the combinations into the queue and also in hashet if they are not in hashset

TC: Exponential
SC: O(n)

n = size of string
"""

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if s == None:
            return result
        
        hset = set()
        q = []
        
        q.append(s)
        hset.add(s)
        flag = False
        
        while len(q) and not flag:
            size = len(q)
            
            for i in range(size):
                curr = q.pop(0)
                if self.isValid(curr):
                    result.append(curr)
                    flag = True
                
                if not flag:
                    for j in range(len(curr)):
                        baby = curr[0:j] + curr[j+1:]
                        if baby not in hset:
                            q.append(baby)
                            hset.add(baby)
                            
        return result
    
    def isValid(self,s):
        count = 0
        for i in range(len(s)):
            c = s[i]
            if c.isalpha():
                continue
            if c == "(":
                count += 1
            else:
                if count == 0:
                    return False 
                count -= 1
                
        return count == 0