# // Time Complexity : o(2^n)
# // Space Complexity : o(2^n *n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We do DFS to remove one bracket at a time and track visited strings.
# Once we find a valid expression, we check if it's the longest so far.
# Only the longest valid strings with the fewest deletions are kept.

from typing import collections,List
# class Solution:
#     def removeInvalidParentheses(self, s: str) -> List[str]:
#         res,q,seen,found = [],collections.deque([s]),set([s]),False
#         def isValid(s):
#             count = 0
#             for c in s:
#                 if c.isalpha():
#                     continue
#                 elif c == '(':
#                     count+=1
#                 elif c == ')':
#                     count-=1
#                 if count <0:
#                     return False
#             return count == 0
#         while q and not found:
#             # remove for every level and check if string is valid
#             for i in range(len(q)):
#                 curr = q.popleft()
#                 if isValid(curr):
#                     res.append(curr)
#                     found = True
#                 elif not found:
#                     for i in range(len(curr)):
#                         # ignore the alphabets
#                         if curr[i].isalpha(): continue
#                         # remove the ith and put the baby in queu to check if valid
#                         baby = curr[:i] + curr[i+1:]
#                         if baby not in seen:
#                             # add baby to queue and seen
#                             q.append(baby)
#                             seen.add(baby)
#         return res

# class Solution:
#     def removeInvalidParentheses(self, s: str) -> List[str]:
#         res,q,seen,found = [],collections.deque([s]),set([s]),False
#         def isValid(s):
#             count = 0
#             for c in s:
#                 if c.isalpha():
#                     continue
#                 elif c == '(':
#                     count+=1
#                 elif c == ')':
#                     count-=1
#                 if count <0:
#                     return False
#             return count == 0
#         while q :
#             curr = q.popleft()
#             if isValid(curr):
#                 res.append(curr)
#                 found = True
#             elif not found:
#                 for i in range(len(curr)):
#                     # ignore the alphabets
#                     if curr[i].isalpha(): continue
#                     # remove the ith and put the baby in queu to check if valid
#                     baby = curr[:i] + curr[i+1:]
#                     if baby not in seen:
#                         # add baby to queue and seen
#                         q.append(baby)
#                         seen.add(baby)
#         return res

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res,self.maxlen,seen = [],0,set([s])
        def isValid(s):
            count = 0
            for c in s:
                if c.isalpha():
                    continue
                elif c == '(':
                    count+=1
                elif c == ')':
                    count-=1
                if count <0:
                    return False
            return count == 0
        def dfs(cs):
            # base if len less than max return
            if len(cs) < self.maxlen : return
            # logic
            if isValid(cs):
                if len(cs) > self.maxlen:
                    self.maxlen = len(cs)
                    res.clear()
                res.append(cs)
            for i in range(len(cs)):
                # ignore alphabet
                if cs[i].isalpha(): continue
                baby = cs[:i]+cs[i+1:]
                if baby not in seen:
                    # call dfs on the baby
                    dfs(baby)
                    seen.add(baby)    
        dfs(s)
        return res


        

        


        