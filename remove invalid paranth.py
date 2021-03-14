"""
Time Complexity : O(2^n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
We use the BFS approach. Put the sting into Q
use flag to know if we found the valid strings if found we do not process the next level.
in while loop, if flag is FALSE we add the new string excluding 1 char from the curr string using for loop
if we find the valid string wee put that into the res
we maintain the hashset to avoid repetations
"""

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s == None or len(s) == 0: return [""]
        res = []
        q = deque()
        flag = False
        hs = set()
        q.append(s)
        hs.add(s)
        # using DFS create the string with different combinations by excluding the brackets
        while(q and not flag):
            size = len(q)
            for i in range(size):
                # popleft while using the queue
                cur = q.popleft()
                # if string is valid we put that into the resultant list
                if self.isValid(cur):
                    res.append(cur)
                    flag = True
                # if flag is false then only we add the children 
                if not flag:
                    for i in range(len(cur)):
                        x = cur[:i] + cur[i+1:]
                        if x not in hs:
                            q.append(x)
                            hs.add(x)
        return res
    # check if the string is valid using counter
    def isValid(self,st):
        count = 0
        for i in st:
            if i == "(":
                count += 1
            elif i.isalpha():
                continue
            elif count == 0:
                return False
            else:
                count -= 1
        return count == 0
                        
            