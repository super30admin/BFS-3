"""
time: O(N)
space: O(N)
"""
import collections
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q = collections.deque([s])
        res = []
        visited = set()
        visited.add(s)
        found = False
        while q:
            strr = q.popleft()
            if self.isValid(strr):
                res.append(strr)
                found = True
            if found: continue
            for i in range(len(strr)):
                if strr[i]=='(' or strr[i]==')':
                    ss = strr[:i] + strr[i+1:]
                    if ss not in visited:
                        q.append(ss)
                        visited.add(ss)
        return res
       
    def isValid(self, s):
        count = 0
        for c in s:
            if c == '(':
                count+=1
            elif c == ')':
                count-=1
            if count<0:
                return False
        return count == 0